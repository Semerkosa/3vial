package com.jointrivial.Reference.service.impl;

import com.google.gson.Gson;
import com.jointrivial.Reference.service.TwelveFinanceService;
import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;
import org.apache.commons.logging.Log;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TwelveFinanceServiceImpl implements TwelveFinanceService {


    private final ModelMapper modelMapper;

    private final Gson gson;

    @Autowired
    public TwelveFinanceServiceImpl(ModelMapper modelMapper, Gson gson) {
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public TwelveDataStockViewModel getCurrentPrice(String symbol) {

        StringBuilder sb = new StringBuilder();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder().uri(URI.create("https://api.twelvedata.com/price?symbol="+symbol+"&apikey=1979f08d77fe41f69ea684f625482255")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(sb::append)
                .join();

        JSONObject jsonObject = new JSONObject(sb.toString());

        //TODO Exception Handling

        return  new TwelveDataStockViewModel(symbol,new BigDecimal(jsonObject.get("price").toString()));
    }

    @Override
    public TwelveDataStockViewModel test(String symbol, String currency) {

        StringBuilder sb = new StringBuilder();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder().uri(URI.create("http://localhost:8090/twelve-data/gerPrice?symbol="+symbol+"-"+currency)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(sb::append)
                .join();

        JSONObject jsonObject = new JSONObject(sb.toString());

        //TODO Exception Handling

        return  new TwelveDataStockViewModel(symbol,new BigDecimal(jsonObject.get("price").toString()));
    }
}
