package com.jointrivial.portfolio.model.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionsInfoServiceModel {

    private String source;
    private LocalDateTime timestamp;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal fxRate;

    //ToDo Add more fields after discussion

    public TransactionsInfoServiceModel() {
    }

    public String getSource() {
        return source;
    }

    public TransactionsInfoServiceModel setSource(String source) {
        this.source = source;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public TransactionsInfoServiceModel setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public TransactionsInfoServiceModel setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TransactionsInfoServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getFxRate() {
        return fxRate;
    }

    public TransactionsInfoServiceModel setFxRate(BigDecimal fxRate) {
        this.fxRate = fxRate;
        return this;
    }
}
