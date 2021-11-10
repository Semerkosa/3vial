package com.jointrivial.sourcemanager.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nordigen_supported_countries")
public class NordigenSupportedCountries extends BaseEntity {

    private String countryName;
    private String countryCode;

    public NordigenSupportedCountries() {
    }

    @Column(name = "country_name", unique = true)
    public String getCountryName() {
        return countryName;
    }

    public NordigenSupportedCountries setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    @Column(name = "country_code", unique = true)
    public String getCountryCode() {
        return countryCode;
    }

    public NordigenSupportedCountries setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }
}
