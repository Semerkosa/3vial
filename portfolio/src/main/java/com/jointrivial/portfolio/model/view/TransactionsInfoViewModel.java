package com.jointrivial.portfolio.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionsInfoViewModel {

    private String source;
    private LocalDateTime timestamp;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal fxRate;

    //ToDo Add more fields after discussion

    public TransactionsInfoViewModel() {
    }

    public String getSource() {
        return source;
    }

    public TransactionsInfoViewModel setSource(String source) {
        this.source = source;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public TransactionsInfoViewModel setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public TransactionsInfoViewModel setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TransactionsInfoViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getFxRate() {
        return fxRate;
    }

    public TransactionsInfoViewModel setFxRate(BigDecimal fxRate) {
        this.fxRate = fxRate;
        return this;
    }
}
