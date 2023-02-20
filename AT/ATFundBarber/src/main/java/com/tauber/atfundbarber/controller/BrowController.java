package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.Brow;
import com.tauber.atfundbarber.service.impl.BrowServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BrowController {
    private final BrowServiceImpl browService;

    @GetMapping("/brows")
    public String brows(Model model) {
        model.addAttribute("brows", browService.getAllBrows());
        return "brows/listBrows";
    }

    @PostMapping("/registerBrow")
    public String registerBrow(Model model, Brow brow) {
        browService.save(brow);
        return brows(model);
    }

}
