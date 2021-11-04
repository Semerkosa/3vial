package com.jointrivial.MockTwelveData.web.model;

public class TwelveDataStockViewModel {

    private String symbol;
    private Double rate;

    public TwelveDataStockViewModel(String symbol, Double rate) {
        this.symbol = symbol;
        this.rate = rate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
