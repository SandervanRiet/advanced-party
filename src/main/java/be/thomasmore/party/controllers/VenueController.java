package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping({"/venuedetails", "/venuedetails/{id}"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "venuedetails";
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
        }
        return "venuedetails";
    }

    @GetMapping({"/venuelist", "/venuelist/{something}"})
    public String venueList(Model model) {
        Iterable<Venue> allVenues = venueRepository.findAll();
        model.addAttribute("venues", allVenues);
        return "venuelist";
    }

    @GetMapping({"/venuelist/outdoor/{filter}", "/venuelist/outdoor"})
    public String venueListOutdoorYes(Model model, @PathVariable(required = false) String filter) {
        boolean boolFilter = true;
        if (filter!=null && (filter.equals("no") || filter.equals("false"))) boolFilter = false;
        Iterable<Venue> venues = venueRepository.findByOutdoor(boolFilter);
        model.addAttribute("outdoorFilter", boolFilter);
        model.addAttribute("venues", venues);
        return "venuelist";
    }





}
