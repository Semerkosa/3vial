package com.jointrivial.Reference.service.impl;

import com.jointrivial.Reference.service.model.YahooFinanceServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;

import java.io.IOException;

@SpringBootTest
class YahooFinanceServiceImplTest {

    @Autowired
    private YahooFinanceServiceImpl yahooFinanceService;

    @Test
    public void getStock()  {

        final YahooFinanceServiceModel yahooFinanceServiceModel = yahooFinanceService.getStock("BTC-USD");


        System.out.println(yahooFinanceServiceModel.getStock());

    }

    @Test
    public void getPriceOfStock() {}  {

        final YahooFinanceServiceModel yahooFinanceServiceModel = yahooFinanceService.getStock("BTC-USD");


        try {
            System.out.println(yahooFinanceServiceModel.getStock().getQuote(true).getPrice());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}