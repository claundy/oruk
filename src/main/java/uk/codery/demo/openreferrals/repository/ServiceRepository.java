package uk.codery.demo.openreferrals.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.codery.demo.openreferrals.model.Service;

import java.util.List;

@Repository
public interface ServiceRepository extends MongoRepository<Service, String> {
    List<Service> findByNameContainingIgnoreCase(String name);
    List<Service> findByOrganizationId(String organizationId);
    List<Service> findByLocationId(String locationId);
}