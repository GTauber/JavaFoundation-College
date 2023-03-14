package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.Hair;
import com.tauber.atfundbarber.service.impl.HairServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HairController {

    private final HairServiceImpl hairService;

    @PostMapping("/registerHair")
    public String registerHair(Model model, Hair hair) {
        hairService.save(hair);
        return listHairs(model);
    }

    @GetMapping("/listHairs")
    public String listHairs(Model model) {
        model.addAttribute("hairs", hairService.getAllHairs());
        return "hairs/listHairs";
    }

    @GetMapping("/hairs")
    public String hairs(Model model) {
        model.addAttribute("hairs", hairService.getAllHairs());
        return "hairs/listHairs";
    }

    @PostMapping("/deleteHair")
    public String deleteHair(Model model, Hair hair) {
        hairService.delete(hair);
        return listHairs(model);
    }


}
