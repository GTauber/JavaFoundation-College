package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.service.impl.BarberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BarberController {

    private final BarberServiceImpl barberService;

    @PostMapping("/registerBarber")
    public String registerBarber(Model model, Barber barber) {
        barberService.save(barber);
        return listBarbers(model);
    }
    @GetMapping("/listBarbers")
    public String listBarbers(Model model) {
        model.addAttribute("barbers", barberService.getAllBarbers());
        return "barbers/listBarbers";
    }

    @PostMapping("/deleteBarber")
    public String deleteBarber(Model model, Barber barber) {
        barberService.delete(barber);
        return listBarbers(model);
    }

}
