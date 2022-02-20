package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Client;
import be.thomasmore.party.repositories.ClientRepository;
import be.thomasmore.party.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping
    public String generateClientCode(Model model){
        Optional<Client> optionalClient = clientRepository.findById(1);
                if(optionalClient.isPresent()){
                    model.addAttribute("code", optionalClient.get());
                }

        String code= optionalClient.get().
    }
}
