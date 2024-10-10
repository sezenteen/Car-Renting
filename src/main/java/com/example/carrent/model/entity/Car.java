package com.example.carrent.model.entity;

import com.example.carrent.model.entity.enums.Color;
import com.example.carrent.model.entity.enums.Gear;
import com.example.carrent.model.entity.enums.Size;
import com.example.carrent.model.entity.enums.Status;
import jakarta.persistence.*;

@Entity
public class Car extends BaseEntity {

    @Column(name = "car_model")
    private String model;

    @Column(name ="car_brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_type")
    private Gear gear;

    @Enumerated(EnumType.STRING) // Or EnumType.ORDINAL
    @Column(name = "car_color")
    private Color color;

    @Column(name = "license_plate")
    private String license;

    @Enumerated(EnumType.STRING) // Or EnumType.ORDINAL
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    private Size size;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gear getGear() { return gear; }

    public void setGear(Gear gear) { this.gear = gear; }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Size getSize() { return size; }

    public void setSize(Size size) { this.size = size; }
}
