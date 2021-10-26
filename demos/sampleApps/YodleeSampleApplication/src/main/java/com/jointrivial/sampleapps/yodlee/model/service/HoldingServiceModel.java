package com.jointrivial.sampleapps.yodlee.model.service;

import com.jointrivial.sampleapps.yodlee.model.beans.HoldingValue;

public class HoldingServiceModel {

    private int id;
    private String holdingType;
    private String description;
    private int accountId;
    private double quantity;
    private HoldingValue value;

    public HoldingServiceModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoldingType() {
        return holdingType;
    }

    public void setHoldingType(String holdingType) {
        this.holdingType = holdingType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public HoldingValue getValue() {
        return value;
    }

    public void setValue(HoldingValue value) {
        this.value = value;
    }
}
