package com.example.carrent.service;

import com.example.carrent.model.entity.Car;
import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();
    Optional<Car> findById(Long id);
    Car save(Car car);
    void deleteById(Long id);
}
