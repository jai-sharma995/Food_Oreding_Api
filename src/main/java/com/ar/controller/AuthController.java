package com.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ar.entity.Restaurant;
import com.ar.repo.RestaurantRepository;

@Controller
public class AuthController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	@GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "register";
    }

    // SAVE RESTAURANT
    @PostMapping("/register")
    public String doRegister(@ModelAttribute Restaurant restaurant,
                             Model model) {

        if (restaurantRepository.existsByUsername(restaurant.getUsername())) {
        	
            model.addAttribute("error", "Username already exists");
            return "register";
        }

        restaurantRepository.save(restaurant);
        return "redirect:/";
    }
	

}
