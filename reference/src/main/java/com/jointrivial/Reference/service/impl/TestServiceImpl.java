package com.jointrivial.Reference.service.impl;

import com.jointrivial.Reference.service.TestSevice;
import com.jointrivial.Reference.web.model.TwelveDataStockViewModel;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class TestServiceImpl implements TestSevice {


    @Override
    public TwelveDataStockViewModel getCurrentPrice(String symbol, String currency) {

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
