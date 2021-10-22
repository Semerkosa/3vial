package com.jointrivial.Reference.service.model;

import yahoofinance.Stock;


public class YahooFinanceServiceModel {
    
    private Stock stock;

    public YahooFinanceServiceModel(Stock stock) {
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }
}
