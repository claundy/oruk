package uk.codery.demo.openreferrals.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.codery.demo.openreferrals.model.Organization;
import uk.codery.demo.openreferrals.repository.OrganizationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    
    private final OrganizationRepository organizationRepository;
    
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
    
    public Optional<Organization> findById(String id) {
        return organizationRepository.findById(id);
    }
    
    public List<Organization> findByName(String name) {
        return organizationRepository.findByNameContainingIgnoreCase(name);
    }
    
    public Organization save(Organization organization) {
        if (organization.getId() == null) {
            organization.setCreatedAt(LocalDateTime.now());
        }
        organization.setUpdatedAt(LocalDateTime.now());
        return organizationRepository.save(organization);
    }
    
    public void deleteById(String id) {
        organizationRepository.deleteById(id);
    }
}