package uk.codery.demo.openreferrals.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.codery.demo.openreferrals.model.Taxonomy;
import uk.codery.demo.openreferrals.repository.TaxonomyRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TaxonomyServiceTest {

    @Mock
    private TaxonomyRepository taxonomyRepository;

    private TaxonomyService taxonomyService;

    @BeforeEach
    public void setUp() {
        taxonomyService = new TaxonomyService(taxonomyRepository);
    }

    @Test
    public void whenGetAllTaxonomies_thenReturnAllTaxonomies() {
        Taxonomy taxonomy1 = new Taxonomy("1", "Food");
        Taxonomy taxonomy2 = new Taxonomy("2", "Housing");
        List<Taxonomy> expectedTaxonomies = Arrays.asList(taxonomy1, taxonomy2);

        given(taxonomyRepository.findAll()).willReturn(expectedTaxonomies);

        List<Taxonomy> actualTaxonomies = taxonomyService.getAllTaxonomies();

        assertThat(actualTaxonomies).isEqualTo(expectedTaxonomies);
        verify(taxonomyRepository).findAll();
    }

    @Test
    public void whenCreateTaxonomy_thenTaxonomyIsSaved() {
        Taxonomy taxonomyToSave = new Taxonomy(null, "Health");
        Taxonomy savedTaxonomy = new Taxonomy("1", "Health");

        given(taxonomyRepository.save(taxonomyToSave)).willReturn(savedTaxonomy);

        Taxonomy result = taxonomyService.createTaxonomy(taxonomyToSave);

        assertThat(result).isEqualTo(savedTaxonomy);
        verify(taxonomyRepository).save(taxonomyToSave);
    }
}