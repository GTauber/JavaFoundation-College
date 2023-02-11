package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.User;
import com.tauber.atfundbarber.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "users/register";
    }

    @PostMapping("/registerUser")
    public String registerUser(User user) {
        log.info("Registering User {}", user);
        userService.saveNewUser(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String users() {
        return "users/users";
    }

    @GetMapping("/test")
    public ModelAndView getAllUsers(ModelAndView modelAndView) {
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/teset")
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ModelAndView("test", "users", users);
    }

}
