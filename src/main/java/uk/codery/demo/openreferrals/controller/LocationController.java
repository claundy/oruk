package uk.codery.demo.openreferrals.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.codery.demo.openreferrals.model.Location;
import uk.codery.demo.openreferrals.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {
    
    private final LocationService locationService;
    
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable String id) {
        return locationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Location>> getLocationsByCity(@PathVariable String city) {
        return ResponseEntity.ok(locationService.findByCity(city));
    }
    
    @GetMapping("/postalcode/{postalCode}")
    public ResponseEntity<List<Location>> getLocationsByPostalCode(@PathVariable String postalCode) {
        return ResponseEntity.ok(locationService.findByPostalCode(postalCode));
    }
    
    @PostMapping
    public ResponseEntity<Location> createLocation(@Valid @RequestBody Location location) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(locationService.save(location));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(
            @PathVariable String id,
            @Valid @RequestBody Location location) {
        return locationService.findById(id)
                .map(existing -> {
                    location.setId(id);
                    return ResponseEntity.ok(locationService.save(location));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable String id) {
        return locationService.findById(id)
                .map(location -> {
                    locationService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}