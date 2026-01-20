package uk.codery.demo.openreferrals.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.codery.demo.openreferrals.model.Service;
import uk.codery.demo.openreferrals.service.LocationService;
import uk.codery.demo.openreferrals.service.OrganizationService;
import uk.codery.demo.openreferrals.service.ServiceService;
import uk.codery.demo.openreferrals.service.TaxonomyService;

@Controller
@RequestMapping("/ui/services")
public class ServiceUIController {

    private final ServiceService serviceService;
    private final OrganizationService organizationService;
    private final LocationService locationService;
    private final TaxonomyService taxonomyService;

    public ServiceUIController(ServiceService serviceService, OrganizationService organizationService, LocationService locationService, TaxonomyService taxonomyService) {
        this.serviceService = serviceService;
        this.organizationService = organizationService;
        this.locationService = locationService;
        this.taxonomyService = taxonomyService;
    }

    @GetMapping
    public String listServices(Model model) {
        model.addAttribute("services", serviceService.findAll());
        return "services/list";
    }

    @GetMapping("/new")
    public String showAddServiceForm(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("organizations", organizationService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("taxonomies", taxonomyService.getAllTaxonomies());
        return "services/form";
    }

    @PostMapping
    public String saveService(@ModelAttribute Service service) {
        serviceService.save(service);
        return "redirect:/ui/services";
    }
}