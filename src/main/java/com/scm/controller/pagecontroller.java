package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForms;
import com.scm.services.UserService;

@Controller
public class pagecontroller {

  @Autowired
  private UserService userService;

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
  public String register(Model model) {
    UserForms userform = new UserForms();
    // by default
    // userform.setName("Harshit");
    // userform.setAbout("Hii");
    // userform.setEmail("harshit200212pandey@gmail.com");
    // userform.setPassword("harshit123");
    // userform.setPhonenumber("7985981426");
    model.addAttribute("userform", userform);
    return "register";
  }

  @RequestMapping(value = "do-register", method = RequestMethod.POST)
  public String processRegister(@ModelAttribute UserForms userform) {
    User user = User.builder()
        .name(userform.getName())
        .email(userform.getEmail())
        .about(userform.getAbout())
        .password(userform.getPassword())
        .phoneNumber(userform.getPhonenumber())
        .profilePic("https://images.app.goo.gl/v2HFayVrDX5UEQLA9")
        .build();
    User savedUser = userService.saveUser(user);
    return "redirect:/register";
  }
}
