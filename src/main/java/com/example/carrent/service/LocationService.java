package com.example.carrent.service;

import com.example.carrent.model.entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> findAll();
    Optional<Location> findById(Long id);
    Location save(Location location);
    void deleteById(Long id);
}
