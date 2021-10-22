package com.jointrivial.MockTwelveData.web.model;

public class TwelveDataStockViewModel {

    private String symbol;
    private Double price;

    public TwelveDataStockViewModel(String symbol, Double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
