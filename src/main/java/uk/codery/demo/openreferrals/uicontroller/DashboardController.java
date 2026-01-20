package uk.codery.demo.openreferrals.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class DashboardController {

    @GetMapping
    public String showDashboard() {
        return "dashboard";
    }
}