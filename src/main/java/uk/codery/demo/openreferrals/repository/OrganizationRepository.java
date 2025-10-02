package uk.codery.demo.openreferrals.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.codery.demo.openreferrals.model.Organization;

import java.util.List;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, String> {
    List<Organization> findByNameContainingIgnoreCase(String name);
}