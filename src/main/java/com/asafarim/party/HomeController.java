package com.asafarim.party;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thomasmore.be.party.model.Venue;


@Controller
public class HomeController {
    private String applicationName = "It's Party Time!!";
    private String message = "Yes let's do it!";
    private Venue[] venues = {
            new Venue(0, "De Club", 150, false, true,
                    "https://transitm.mechelen.be/infofiche_declubpdf"),
            new Venue(1, "De Loods", 1000, false, true,
                    "https://transitm.mechelen.be/infofiche-deloodspdf"),
            new Venue(2, "Zapoi", false, false, "http://www.kafeezapoi.be/"),
            new Venue(3, "De Kuub", false, true, "http://www.dekuub.be/"),
            new Venue(4, "t'Ile Maline", false, true, "https://www.tilemalines.be/"),
    };


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("appName", applicationName);
        model.addAttribute("message", message);
        model.addAttribute("venues", venues);
        return "home";
    }

    @GetMapping("/blabla")
    public String blabla(Model model) {
        model.addAttribute("appName", applicationName);
        model.addAttribute("message", message);
        return "blabla";
    }

    @GetMapping({"/venue/{venueId}"})
    public String venue(@PathVariable int venueId, Model model) {
        model.addAttribute("appName", applicationName);
        model.addAttribute("message", message);
        model.addAttribute("venue", venues[venueId]);
        model.addAttribute("idOfPrevVenue", venueId > 0 ? venueId - 1 : venues.length - 1);
        model.addAttribute("idOfNextVenue", venueId< venues.length-1 ? venueId + 1 : 0);
        return "venue";
    }

    @GetMapping({"/venue"})
    public String venue(Model model) {
        model.addAttribute("appName", applicationName);
        model.addAttribute("message", message);
        model.addAttribute("venueName", null);
        model.addAttribute("venue", null);
        return "venue";
    }

}

