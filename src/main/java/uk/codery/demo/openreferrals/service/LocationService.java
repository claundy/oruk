package uk.codery.demo.openreferrals.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.codery.demo.openreferrals.model.Location;
import uk.codery.demo.openreferrals.repository.LocationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    
    private final LocationRepository locationRepository;
    
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    
    public Optional<Location> findById(String id) {
        return locationRepository.findById(id);
    }
    
    public List<Location> findByCity(String city) {
        return locationRepository.findByCity(city);
    }
    
    public List<Location> findByPostalCode(String postalCode) {
        return locationRepository.findByPostalCode(postalCode);
    }
    
    public Location save(Location location) {
        if (location.getId() == null) {
            location.setCreatedAt(LocalDateTime.now());
        }
        location.setUpdatedAt(LocalDateTime.now());
        return locationRepository.save(location);
    }
    
    public void deleteById(String id) {
        locationRepository.deleteById(id);
    }
}