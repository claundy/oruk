package uk.codery.demo.openreferrals.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.codery.demo.openreferrals.model.Location;

import java.util.List;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    List<Location> findByCity(String city);
    List<Location> findByPostalCode(String postalCode);
}