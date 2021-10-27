package com.jointrivial.sampleapps.yodlee.model.view;

public class HoldingViewModel {

    private int id;
    private String holdingType;
    private double quantity;
    private String description;
    private HoldingValueViewModel value;

    public HoldingViewModel() {
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HoldingValueViewModel getValue() {
        return value;
    }

    public void setValue(HoldingValueViewModel value) {
        this.value = value;
    }
}
