package com.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ar.entity.UserDetails;
import com.ar.repo.UserDetailsrepo;

@Controller
public class Userlogin {

    @Autowired
    private UserDetailsrepo repo;

    @GetMapping("/userDetailsLogin")
    public String showLoginPage() {
        return "userDetailsLogin";
    }

    @PostMapping("/userDetailsLogin")
    public String loginUser(@RequestParam("mobileno") String mobileno,
                            @RequestParam("password") String password,
                            Model model) {

        UserDetails user = repo.findByMobilenoAndPassword(mobileno, password);

        if (user != null) {
            model.addAttribute("username", user.getUsername());
            return "Food_Order_Alert_Page";
        } else {
            model.addAttribute("error", "Invalid Mobile Number or Password");
            return "userDetailsLogin";
        }
    }
    
    
    
    @GetMapping("/Food_Order_Alert_Page")
    public String foog_alert_Page() {
        return "Food_Order_Alert_Page.html";
    }
    
}