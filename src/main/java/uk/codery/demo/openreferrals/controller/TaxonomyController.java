package uk.codery.demo.openreferrals.controller;

import org.springframework.web.bind.annotation.*;
import uk.codery.demo.openreferrals.model.Taxonomy;
import uk.codery.demo.openreferrals.service.TaxonomyService;

import java.util.List;

@RestController
@RequestMapping("/taxonomies")
public class TaxonomyController {

    private final TaxonomyService taxonomyService;

    public TaxonomyController(TaxonomyService taxonomyService) {
        this.taxonomyService = taxonomyService;
    }

    @GetMapping
    public List<Taxonomy> getAllTaxonomies() {
        return taxonomyService.getAllTaxonomies();
    }

    @PostMapping
    public Taxonomy createTaxonomy(@RequestBody Taxonomy taxonomy) {
        return taxonomyService.createTaxonomy(taxonomy);
    }
}