package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.MessageType;
import com.scm.helper.Messages;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String index() {
    return "redirect:/home";
  }

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
    UserForm userform = new UserForm();
    // by default
    // userform.setName("Harshit");
    // userform.setAbout("Hii");
    // userform.setEmail("harshit200212pandey@gmail.com");
    // userform.setPassword("harshit123");
    // userform.setPhonenumber("7985981426");
    model.addAttribute("userform", userform);
    return "register";
  }

  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@Valid @ModelAttribute("userform") UserForm userform, BindingResult rBindingResult,
      HttpSession session) {

    if (rBindingResult.hasErrors()) {
      return "register";
    }

    // User user = User.builder()
    // .name(userform.getName())
    // .email(userform.getEmail())
    // .about(userform.getAbout())
    // .password(userform.getPassword())
    // .phoneNumber(userform.getPhonenumber())
    // .profilePic("https://images.app.goo.gl/v2HFayVrDX5UEQLA9")
    // .build();

    User user = new User();
    user.setName(userform.getName());
    user.setEmail(userform.getEmail());
    user.setPassword(userform.getPassword());
    user.setAbout(userform.getAbout());
    user.setPhoneNumber(userform.getPhonenumber());
    user.setEnabled(true);
    user.setProfilePic("https://images.app.goo.gl/v2HFayVrDX5UEQLA9");
    User savedUser = userService.saveUser(user);
    Messages message = Messages.builder().content("Registration Successful").type(MessageType.green).build();
    session.setAttribute("message", message);
    return "redirect:/register";
  }
}
