package uk.codery.demo.openreferrals.service;

import org.springframework.stereotype.Service;
import uk.codery.demo.openreferrals.model.Taxonomy;
import uk.codery.demo.openreferrals.repository.TaxonomyRepository;

import java.util.List;

@Service
public class TaxonomyService {

    private final TaxonomyRepository taxonomyRepository;

    public TaxonomyService(TaxonomyRepository taxonomyRepository) {
        this.taxonomyRepository = taxonomyRepository;
    }

    public List<Taxonomy> getAllTaxonomies() {
        return taxonomyRepository.findAll();
    }

    public Taxonomy createTaxonomy(Taxonomy taxonomy) {
        return taxonomyRepository.save(taxonomy);
    }
}