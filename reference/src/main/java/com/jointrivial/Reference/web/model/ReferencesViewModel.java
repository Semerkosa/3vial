package com.jointrivial.Reference.web.model;

import java.util.ArrayList;
import java.util.List;

public class ReferencesViewModel {

    private List<TwelveDataStockViewModel> references;

    public ReferencesViewModel() {

        this.references = new ArrayList<>();
    }

    public void addModel(TwelveDataStockViewModel model) {
        this.references.add(model);
    }


    public List<TwelveDataStockViewModel> getReferences() {
        return references;
    }

    public void setReferences(List<TwelveDataStockViewModel> references) {
        this.references = references;
    }
}
