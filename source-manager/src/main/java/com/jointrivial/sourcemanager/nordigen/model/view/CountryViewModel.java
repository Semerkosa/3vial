package com.jointrivial.sourcemanager.nordigen.model.view;

public class CountryViewModel {

    private String countryName;
    private String countryCode;

    public CountryViewModel() {
    }

    public String getCountryName() {
        return countryName;
    }

    public CountryViewModel setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CountryViewModel setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }
}
