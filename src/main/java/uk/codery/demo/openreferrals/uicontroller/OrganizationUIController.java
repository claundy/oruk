package uk.codery.demo.openreferrals.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.codery.demo.openreferrals.model.Organization;
import uk.codery.demo.openreferrals.service.OrganizationService;

@Controller
@RequestMapping("/ui/organizations")
public class OrganizationUIController {

    private final OrganizationService organizationService;

    public OrganizationUIController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public String listOrganizations(Model model) {
        model.addAttribute("organizations", organizationService.findAll());
        return "organizations/list";
    }

    @GetMapping("/new")
    public String showAddOrganizationForm(Model model) {
        model.addAttribute("organization", new Organization());
        return "organizations/form";
    }

    @PostMapping
    public String saveOrganization(@ModelAttribute Organization organization) {
        organizationService.save(organization);
        return "redirect:/ui/organizations";
    }
}