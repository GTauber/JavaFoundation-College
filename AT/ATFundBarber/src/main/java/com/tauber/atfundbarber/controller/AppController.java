package com.tauber.atfundbarber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

      @GetMapping("/")
      public String index() {
          return "index";
      }

      @GetMapping("/login")
      public String login() {
          return "users/userLogin";
      }

      @GetMapping("/home")
      public String home() {
          return "home";
      }

      @GetMapping("/logged/registerUser")
      public String registerUserFromLoggedArea() {
          return "users/newUserFromList";
      }

      @GetMapping("/barbers")
      public String barbers() {
          return "barbers/listBarbers";
      }

      @GetMapping("/registerBarber")
      public String registerBarber() {
          return "barbers/register";
      }
}
