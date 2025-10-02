package uk.codery.demo.openreferrals.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uk.codery.demo.openreferrals.model.Service;
import uk.codery.demo.openreferrals.service.ServiceService;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@WebMvcTest(ServiceController.class)
public class ServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ServiceService serviceService;

    @Test
    public void whenGetServicesByTaxonomy_thenReturnJsonArray() throws Exception {
        Service service = new Service();
        service.setName("Test Service");
        List<Service> services = Collections.singletonList(service);
        String taxonomyName = "test-taxonomy";

        given(serviceService.findByTaxonomyName(taxonomyName)).willReturn(services);

        mvc.perform(get("/api/services/taxonomy/" + taxonomyName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(service.getName())));
    }
}