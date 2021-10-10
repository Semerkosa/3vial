package com.jointrivial.Reference.service.impl;

import com.jointrivial.Reference.service.model.YahooFinanceServiceModel;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class YahooFinanceServiceImpl {


    public YahooFinanceServiceModel getStock(String symbol){

        try {
            return new YahooFinanceServiceModel(YahooFinance.get(symbol));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public BigDecimal findPrice(YahooFinanceServiceModel yahooFinanceServiceModel){

        try {
            return yahooFinanceServiceModel.getStock().getQuote(true).getPrice();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


}
