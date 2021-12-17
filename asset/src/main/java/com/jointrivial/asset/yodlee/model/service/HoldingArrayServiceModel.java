package com.jointrivial.asset.yodlee.model.service;

import com.google.gson.annotations.Expose;

public class HoldingArrayServiceModel {

    @Expose
    private HoldingServiceModel[] holding;

    public HoldingArrayServiceModel() {
    }

    public HoldingServiceModel[] getHolding() {
        return holding;
    }

    public void setHolding(HoldingServiceModel[] holding) {
        this.holding = holding;
    }
}
