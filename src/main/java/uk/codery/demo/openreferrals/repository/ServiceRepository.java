package uk.codery.demo.openreferrals.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uk.codery.demo.openreferrals.model.Service;

import java.util.List;

public interface ServiceRepository extends MongoRepository<Service, String> {
    List<Service> findByNameContainingIgnoreCase(String name);
    List<Service> findByOrganizationId(String organizationId);
    List<Service> findByLocationId(String locationId);

    @Query("{ 'taxonomies.name' : ?0 }")
    List<Service> findByTaxonomyName(String taxonomyName);
}