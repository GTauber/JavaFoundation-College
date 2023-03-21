package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.Barber;
import com.tauber.atfundbarber.model.entity.User;
import com.tauber.atfundbarber.service.impl.BarberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@AllArgsConstructor
@SessionAttributes("userSession")
public class BarberController {

    private final BarberServiceImpl barberService;

    @PostMapping("/registerBarber")
    public String registerBarber(@SessionAttribute("userSession") User user, Model model, Barber barber) {
        barber.setUser(user);
        user.getBarbers().add(barber);
        barberService.save(barber);
        return listBarbers(model, user);
    }
    @GetMapping("/listBarbers")
    public String listBarbers(Model model, @SessionAttribute("userSession") User user) {
        model.addAttribute("barbers", barberService.getBarberByUser(user));
        return "barbers/listBarbers";
    }

    @PostMapping("/deleteBarber")
    public String deleteBarber(Model model, Barber barber, @SessionAttribute("userSession") User user) {
        barberService.delete(barber);
        return listBarbers(model, user);
    }

}
