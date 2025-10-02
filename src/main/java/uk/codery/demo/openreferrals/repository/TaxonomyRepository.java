package uk.codery.demo.openreferrals.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.codery.demo.openreferrals.model.Taxonomy;

public interface TaxonomyRepository extends MongoRepository<Taxonomy, String> {
}