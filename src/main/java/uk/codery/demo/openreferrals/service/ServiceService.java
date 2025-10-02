package uk.codery.demo.openreferrals.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.codery.demo.openreferrals.repository.ServiceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceService {
    
    private final ServiceRepository serviceRepository;
    
    public List<uk.codery.demo.openreferrals.model.Service> findAll() {
        return serviceRepository.findAll();
    }
    
    public Optional<uk.codery.demo.openreferrals.model.Service> findById(String id) {
        return serviceRepository.findById(id);
    }
    
    public List<uk.codery.demo.openreferrals.model.Service> findByName(String name) {
        return serviceRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<uk.codery.demo.openreferrals.model.Service> findByOrganizationId(String organizationId) {
        return serviceRepository.findByOrganizationId(organizationId);
    }
    
    public List<uk.codery.demo.openreferrals.model.Service> findByLocationId(String locationId) {
        return serviceRepository.findByLocationId(locationId);
    }
    
    public uk.codery.demo.openreferrals.model.Service save(uk.codery.demo.openreferrals.model.Service service) {
        if (service.getId() == null) {
            service.setCreatedAt(LocalDateTime.now());
        }
        service.setUpdatedAt(LocalDateTime.now());
        return serviceRepository.save(service);
    }
    
    public void deleteById(String id) {
        serviceRepository.deleteById(id);
    }
}