package com.wedding.datamanager.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pipe on 8/5/17.
 */

@Data
public class Location {
    private Address address;
    private String name;
    private String telephone;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
