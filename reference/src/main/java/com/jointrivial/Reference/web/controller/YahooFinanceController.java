package com.jointrivial.Reference.web.controller;

import com.jointrivial.Reference.service.impl.YahooFinanceServiceImpl;
import com.jointrivial.Reference.service.model.YahooFinanceServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reference/yahoo")
public class YahooFinanceController {

    private final YahooFinanceServiceImpl yahooFinanceService;

    @Autowired
    public YahooFinanceController(YahooFinanceServiceImpl yahooFinanceService) {
        this.yahooFinanceService = yahooFinanceService;
    }

    @GetMapping("/getStock")
    public YahooFinanceServiceModel getStock(){

        return this.yahooFinanceService.getStock("BTC-USD");
    }
}
