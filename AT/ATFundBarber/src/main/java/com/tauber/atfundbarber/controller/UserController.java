package com.tauber.atfundbarber.controller;

import com.tauber.atfundbarber.model.entity.DTO.UserDto;
import com.tauber.atfundbarber.model.entity.User;
import com.tauber.atfundbarber.service.UserService;
import com.tauber.atfundbarber.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

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

    @PostMapping("/login")
    public String login(Model model, UserDto userDto) {
        log.info("Logging in User {}", userDto);
        var loggedUser = userService.validateUser(userDto);

        if (loggedUser.isPresent()) {
            return "home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "users/userLogin";
    }
    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/listUsers";
    }

    @PostMapping("/logged/registerUser")
    public String registerUserFromLoggedArea(Model model, User user) {
        log.info("Registering User {}", user);
        userService.saveNewUser(user);
        model.addAttribute("success", "User registered successfully");
        return listUsers(model);
    }

}
