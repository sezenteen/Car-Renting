package com.example.carrent.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Location extends BaseEntity{

    private String location;
    private String address;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
