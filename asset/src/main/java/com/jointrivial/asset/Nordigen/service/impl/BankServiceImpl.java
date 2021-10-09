package com.jointrivial.asset.Nordigen.service.impl;

import com.google.gson.Gson;
import com.jointrivial.asset.Nordigen.api.HttpRequests;
import com.jointrivial.asset.Nordigen.exceptions.InvalidCountryException;
import com.jointrivial.asset.Nordigen.models.services.BankServiceModel;
import com.jointrivial.asset.Nordigen.service.BankService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    private final Gson gson;
    private final HttpRequests httpRequests;

    public BankServiceImpl(Gson gson, HttpRequests httpRequests) {
        this.gson = gson;
        this.httpRequests = httpRequests;
    }

    @Override
    public List<String> allBanksInCountry(String country) throws IOException, URISyntaxException, InterruptedException{
        String banksJson = httpRequests.allBanksInCountry(country);

        // TODO handle exception properly
        if (banksJson == null) {
            return null;
        }

        BankServiceModel[] bankServiceModels = this.gson.fromJson(banksJson, BankServiceModel[].class);

        return Arrays.stream(bankServiceModels).
                map(BankServiceModel::getName).
                collect(Collectors.toList());
    }
}
