package com.example.carrent.repository;

import com.example.carrent.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // Additional custom query methods can be defined here, if needed
}
