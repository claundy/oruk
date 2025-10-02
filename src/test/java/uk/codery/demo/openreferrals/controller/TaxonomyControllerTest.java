package uk.codery.demo.openreferrals.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uk.codery.demo.openreferrals.model.Taxonomy;
import uk.codery.demo.openreferrals.service.TaxonomyService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@WebMvcTest(TaxonomyController.class)
public class TaxonomyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaxonomyService taxonomyService;

    @Test
    public void whenGetAllTaxonomies_thenReturnJsonArray() throws Exception {
        Taxonomy taxonomy = new Taxonomy("1", "test");
        List<Taxonomy> allTaxonomies = Arrays.asList(taxonomy);

        given(taxonomyService.getAllTaxonomies()).willReturn(allTaxonomies);

        mvc.perform(get("/taxonomies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(taxonomy.getName())));
    }

    @Test
    public void whenPostTaxonomy_thenCreateTaxonomy() throws Exception {
        Taxonomy taxonomy = new Taxonomy(null, "test");
        given(taxonomyService.createTaxonomy(taxonomy)).willReturn(new Taxonomy("1", "test"));

        mvc.perform(post("/taxonomies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"test\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.name", is("test")));
    }
}