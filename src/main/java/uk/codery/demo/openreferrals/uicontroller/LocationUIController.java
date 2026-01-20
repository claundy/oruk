package uk.codery.demo.openreferrals.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.codery.demo.openreferrals.model.Location;
import uk.codery.demo.openreferrals.service.LocationService;

@Controller
@RequestMapping("/ui/locations")
public class LocationUIController {

    private final LocationService locationService;

    public LocationUIController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public String listLocations(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "locations/list";
    }

    @GetMapping("/new")
    public String showAddLocationForm(Model model) {
        model.addAttribute("location", new Location());
        return "locations/form";
    }

    @PostMapping
    public String saveLocation(@ModelAttribute Location location) {
        locationService.save(location);
        return "redirect:/ui/locations";
    }
}