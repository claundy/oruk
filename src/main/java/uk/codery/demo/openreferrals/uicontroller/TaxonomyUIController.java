package uk.codery.demo.openreferrals.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.codery.demo.openreferrals.model.Taxonomy;
import uk.codery.demo.openreferrals.service.TaxonomyService;

@Controller
@RequestMapping("/ui/taxonomies")
public class TaxonomyUIController {

    private final TaxonomyService taxonomyService;

    public TaxonomyUIController(TaxonomyService taxonomyService) {
        this.taxonomyService = taxonomyService;
    }

    @GetMapping
    public String listTaxonomies(Model model) {
        model.addAttribute("taxonomies", taxonomyService.getAllTaxonomies());
        return "taxonomies/list";
    }

    @GetMapping("/new")
    public String showAddTaxonomyForm(Model model) {
        model.addAttribute("taxonomy", new Taxonomy());
        return "taxonomies/form";
    }

    @PostMapping
    public String saveTaxonomy(@ModelAttribute Taxonomy taxonomy) {
        taxonomyService.createTaxonomy(taxonomy);
        return "redirect:/ui/taxonomies";
    }
}