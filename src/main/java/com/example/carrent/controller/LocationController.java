package com.example.carrent.controller;

import com.example.carrent.model.entity.Category;
import com.example.carrent.model.entity.Location;
import com.example.carrent.service.CategoryService;
import com.example.carrent.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // GET all categories
    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }

    // GET category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationService.findById(id);
        return location.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST to create a new category
    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.save(location);
    }

    // PUT to update a category by ID
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location locationDetails) {
        Optional<Location> optionalLocation = locationService.findById(id);
        if (optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setLocation(locationDetails.getLocation());
            location.setAddress(locationDetails.getAddress());
            // Don't update cars list here unless you're sure you want to
            return ResponseEntity.ok(locationService.save(location));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()) {
            locationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
