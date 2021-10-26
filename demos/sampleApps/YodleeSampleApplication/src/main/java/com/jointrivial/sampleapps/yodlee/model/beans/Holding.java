package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the holding (asset) data from Yodlee's JSON response
// Not all fields are included in order to keep the structure simple

public class Holding {

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

    @Expose
    private HoldingValue value = new HoldingValue("default", 0);

    public Holding() {
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

    @Override
    public String toString() {
        return "HoldingId: " + getId() + "\n" +
                "HoldingType: " + getHoldingType() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Quantity: " + getQuantity() + "\n" +
                "Value: " + getValue() + "\n" +
                "AccountId: " + getAccountId();
    }
}
