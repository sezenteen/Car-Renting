package com.example.carrent.controller;

import com.example.carrent.model.entity.Car;
import com.example.carrent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.findById(id);
        return car.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Optional<Car> optionalCar = carService.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setModel(carDetails.getModel());
            car.setBrand(carDetails.getBrand());
            car.setCategory(carDetails.getCategory());
            car.setGear(carDetails.getGear());
            car.setColor(carDetails.getColor());
            car.setLicense(carDetails.getLicense());
            car.setStatus(carDetails.getStatus());
            car.setSize(carDetails.getSize());
            return ResponseEntity.ok(carService.save(car));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        Optional<Car> car = carService.findById(id);
        if (car.isPresent()) {
            carService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
