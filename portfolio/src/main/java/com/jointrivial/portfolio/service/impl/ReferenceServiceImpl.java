package com.jointrivial.portfolio.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jointrivial.portfolio.exceptions.IllegalInputCurrencyException;
import com.jointrivial.portfolio.model.service.balance.UserBalancesServiceModel;
import com.jointrivial.portfolio.model.view.balance.BalanceViewModel;
import com.jointrivial.portfolio.model.view.balance.UserBalancesViewModel;
import com.jointrivial.portfolio.service.ReferenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReferenceServiceImpl implements ReferenceService {
    private static final String PRICES_URL = "http://localhost:8081/reference/prices";
    private final Gson gson;
    private final HttpClient client;
    private final ModelMapper modelMapper;

    @Autowired
    public ReferenceServiceImpl(Gson gson, HttpClient client, ModelMapper modelMapper) {
        this.gson = gson;
        this.client = client;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserBalancesViewModel calculateAmountInWantedCurrency(String currency, UserBalancesServiceModel balances) throws URISyntaxException, IOException, InterruptedException {
        if (balances == null || balances.getUserBalances() == null) {
            // empty balances means user has no accounts linked yet
            return new UserBalancesViewModel();
        }
        if (currency == null || currency.isEmpty() || currency.isBlank()) {
            throw new IllegalInputCurrencyException("Input currency is empty!");
        }
        Set<String> currencies = balances.getUserBalances().stream()
                .flatMap(e -> e.getBalances().stream().map(k -> k.getBalanceAmount().getCurrency()))
                .collect(Collectors.toSet());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(PRICES_URL))
                .setHeader("Currency", currency)
                .setHeader("Currencies", currencies.toString().replaceAll("[\\[\\]]", ""))
                .GET()
                .build();
        UserBalancesViewModel userBalancesViewModel = modelMapper.map(balances, UserBalancesViewModel.class);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Map<String, BigDecimal> referenceData = gson.fromJson(response.body(), new TypeToken<Map<String, BigDecimal>>() {
        }.getType());
        userBalancesViewModel.getUserBalances().stream()
                .flatMap(e -> e.getBalances().stream().map(BalanceViewModel::getBalanceAmount))
                .forEach(a -> a.setAmountInWantedCurrency(a.getAmount().multiply(referenceData.get(a.getCurrency())).setScale(2, RoundingMode.HALF_UP)));

        return userBalancesViewModel;
    }
}
