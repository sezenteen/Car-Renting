package com.example.carrent.model.entity;

import com.example.carrent.model.entity.enums.Size;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "category_name")
    private Size size;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Car> cars;

    @Column(name = "daily_price", nullable = false)
    private BigDecimal dailyPrice;

    // Getters and Setters


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public BigDecimal getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(BigDecimal dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
}
