package com.wedding.datamanager.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pipe on 8/5/17.
 */

@Data
public class Address {
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
