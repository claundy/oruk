package uk.codery.demo.openreferrals.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.codery.demo.openreferrals.model.Organization;
import uk.codery.demo.openreferrals.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    
    private final OrganizationService organizationService;
    
    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable String id) {
        return organizationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Organization>> searchOrganizations(@RequestParam String name) {
        return ResponseEntity.ok(organizationService.findByName(name));
    }
    
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@Valid @RequestBody Organization organization) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizationService.save(organization));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrganization(
            @PathVariable String id,
            @Valid @RequestBody Organization organization) {
        return organizationService.findById(id)
                .map(existing -> {
                    organization.setId(id);
                    return ResponseEntity.ok(organizationService.save(organization));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable String id) {
        return organizationService.findById(id)
                .map(organization -> {
                    organizationService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}