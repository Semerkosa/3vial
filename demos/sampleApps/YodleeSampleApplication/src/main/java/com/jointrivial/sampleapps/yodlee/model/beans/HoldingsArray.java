package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the holding array data from Yodlee's JSON response

public class HoldingsArray {

    @Expose
    private Holding[] holding;

    public HoldingsArray() {
    }

    public Holding[] getHolding() {
        return holding;
    }

    public void setHolding(Holding[] holding) {
        this.holding = holding;
    }
}
