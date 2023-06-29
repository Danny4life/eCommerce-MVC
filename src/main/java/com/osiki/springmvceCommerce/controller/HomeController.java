package com.osiki.springmvceCommerce.controller;

import com.osiki.springmvceCommerce.model.UserModel;
import com.osiki.springmvceCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")

    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UserModel());
        return "register";
    }

    @GetMapping("/login")

    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UserModel());
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel){
        System.out.println("Register request " + userModel);

        UserModel registerUser = userService.registerUser(userModel.getLogin(), userModel.getPassword(), userModel.getEmail());

        return registerUser == null ? "error_page" : "redirect:/login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("Login request " + userModel);

        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());

       if(authenticated != null){
           model.addAttribute("userLogin", userModel.getLogin());
            return "personal_page";
       } else {
           return "error_page";
       }

    }
}
