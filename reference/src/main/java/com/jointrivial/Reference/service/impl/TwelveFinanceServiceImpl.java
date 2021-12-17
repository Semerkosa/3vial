package com.jointrivial.Reference.service.impl;

import com.jointrivial.Reference.service.TwelveFinanceService;
import com.jointrivial.Reference.web.model.ReferencesViewModel;
import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static javax.swing.UIManager.get;

@Service
public class TwelveFinanceServiceImpl implements TwelveFinanceService {

    private final static String URL_TWELVE_DATA = "https://api.twelvedata.com/exchange_rate?symbol=%s/%s&apikey=%s";
    private final static String TEST_URL = "http://localhost:8090/exchange_rate?symbol=%s";

    @Override
    public ReferencesViewModel getCurrentPrice(String currency,List<String> symbols) {

        StringBuilder response = new StringBuilder();

        ReferencesViewModel output = new ReferencesViewModel();

        //For production purposes -> String.format(URL_TWELVE_DATA,symbol,currency,System.getenv("API_KEY")
        //For test purposes -> String.format(TEST_URL,symbol+"-"+currency

        for (String symbol : symbols) {

            HttpClient twelveDataService = HttpClient.newHttpClient();
            HttpRequest getExchangeRate =  HttpRequest.newBuilder()
                    .uri(URI.create(String.format(TEST_URL, symbol + "-" + currency)))
                    .build();
            twelveDataService.sendAsync(getExchangeRate, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(response::append)
                    .join();

            BigDecimal decimal = new BigDecimal(new JSONObject(response.toString()).get("rate").toString());

            TwelveDataStockViewModel current = new TwelveDataStockViewModel(symbol, decimal);
            output.addModel(current);
            response.setLength(0);
        }

        return output;
    }

}
