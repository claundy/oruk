package uk.codery.demo.openreferrals.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.codery.demo.openreferrals.model.Service;
import uk.codery.demo.openreferrals.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {
    
    private final ServiceService serviceService;
    
    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        return ResponseEntity.ok(serviceService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable String id) {
        return serviceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Service>> searchServices(@RequestParam String name) {
        return ResponseEntity.ok(serviceService.findByName(name));
    }
    
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<Service>> getServicesByOrganization(@PathVariable String organizationId) {
        return ResponseEntity.ok(serviceService.findByOrganizationId(organizationId));
    }
    
    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<Service>> getServicesByLocation(@PathVariable String locationId) {
        return ResponseEntity.ok(serviceService.findByLocationId(locationId));
    }

    @GetMapping("/taxonomy/{taxonomyName}")
    public ResponseEntity<List<Service>> getServicesByTaxonomy(@PathVariable String taxonomyName) {
        return ResponseEntity.ok(serviceService.findByTaxonomyName(taxonomyName));
    }
    
    @PostMapping
    public ResponseEntity<Service> createService(@Valid @RequestBody Service service) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceService.save(service));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(
            @PathVariable String id,
            @Valid @RequestBody Service service) {
        return serviceService.findById(id)
                .map(existing -> {
                    service.setId(id);
                    return ResponseEntity.ok(serviceService.save(service));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable String id) {
        return serviceService.findById(id)
                .map(service -> {
                    serviceService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}