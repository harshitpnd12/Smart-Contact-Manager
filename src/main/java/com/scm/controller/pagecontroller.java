package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pagecontroller {
  @RequestMapping("/home")
  public String home(Model model) {
    System.out.println("Home page Handler");
    model.addAttribute("name", "Harshit Pandey");
    model.addAttribute("github", "https://github.com/harshitpnd12");
    return "home";
  }

  // About route
  @RequestMapping("/about")
  public String aboutpage() {
    System.out.println("About page loading");
    return "about";
  }

  // Services
  @RequestMapping("/service")
  public String service() {
    System.out.println("Service page loading");
    return "service";
  }

  @RequestMapping("/login")
  public String login() {
    System.out.println("Login page loading");
    return "login";
  }

  @RequestMapping("/contact")
  public String contact() {
    System.out.println("Contact page loading");
    return "contact";
  }

  @RequestMapping("/register")
  public String register() {
    System.out.println("Register page loading");
    return "register";
  }
}
