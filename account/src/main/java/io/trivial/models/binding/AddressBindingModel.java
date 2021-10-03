package io.trivial.models.binding;

import javax.validation.constraints.Pattern;

import static io.trivial.constants.RegexConstants.*;

public class AddressBindingModel {

    private String city;
    private String country;
    private String postCode;
    private String street;
    private String streetNumber;

    public AddressBindingModel() {
    }

    @Pattern(regexp = CITY_REGEX, message = CITY_REGEX_ERROR)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Pattern(regexp = COUNTRY_REGEX, message = COUNTRY_REGEX_ERROR)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Pattern(regexp = POST_CODE_REGEX, message = POST_CODE_REGEX_ERROR)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Pattern(regexp = STREET_REGEX, message = STREET_REGEX_ERROR)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Pattern(regexp = STREET_NUMBER_REGEX, message = STREET_NUMBER_REGEX_ERROR)
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
