package uk.codery.demo.openreferrals.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.codery.demo.openreferrals.model.Service;
import uk.codery.demo.openreferrals.repository.ServiceRepository;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ServiceServiceTest {

    @Mock
    private ServiceRepository serviceRepository;

    private ServiceService serviceService;

    @BeforeEach
    public void setUp() {
        serviceService = new ServiceService(serviceRepository);
    }

    @Test
    public void whenFindByTaxonomyName_thenReturnServices() {
        Service service = new Service();
        service.setName("Test Service");
        List<Service> expectedServices = Collections.singletonList(service);
        String taxonomyName = "test-taxonomy";

        given(serviceRepository.findByTaxonomyName(taxonomyName)).willReturn(expectedServices);

        List<Service> actualServices = serviceService.findByTaxonomyName(taxonomyName);

        assertThat(actualServices).isEqualTo(expectedServices);
        verify(serviceRepository).findByTaxonomyName(taxonomyName);
    }
}