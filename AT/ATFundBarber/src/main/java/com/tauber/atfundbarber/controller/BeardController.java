package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.Beard;
import com.tauber.atfundbarber.service.impl.BeardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BeardController {

    private final BeardServiceImpl beardService;

    @GetMapping("/beards")
    public String beards(Model model) {
        model.addAttribute("beards", beardService.getAllBeards());
        return "beards/listBeards";
    }

    @PostMapping("/registerBeard")
    public String registerBeard(Model model, Beard beard) {
        beardService.save(beard);
        return beards(model);
    }

    @PostMapping("/deleteBeard")
    public String deleteBeard(Model model, Beard beard) {
        beardService.delete(beard);
        return beards(model);
    }

}
