package com.jointrivial.asset.yodlee.model.service;

import com.google.gson.annotations.Expose;

public class HoldingServiceModel {

    @Expose
    private int id;

    @Expose
    private String holdingType;

    @Expose
    private String description;

    @Expose
    private int accountId;

    @Expose
    private double quantity;

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
}
