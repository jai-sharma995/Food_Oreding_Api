package com.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ar.entity.Menu;
import com.ar.entity.Orders;
import com.ar.entity.UserDetails;
import com.ar.print.PdfGenerator;
import com.ar.repo.MenuRepo;
import com.ar.repo.OrderRepository;
import com.ar.service.UserDetaileSerview;

@Controller
public class UserController {
	@Autowired
	private UserDetaileSerview userDetaileSerview;
	
	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private MenuRepo menuRepo;

	public UserController(UserDetaileSerview userDetaileSerview) {
		super();
		this.userDetaileSerview = userDetaileSerview;
	} 
	
	@GetMapping("/userDetails")
	public String adduser(Model model) {
		model.addAttribute("details", new UserDetails());
		return "userDetails";
	}
	
	@PostMapping("/userDetails")
	public String addUser(@ModelAttribute UserDetails details) {
		userDetaileSerview.saveDetails(details);
<<<<<<< HEAD
		return "userDetailsLogin";
=======
		return "foodlist";
>>>>>>> 38d640902c8213dfea6914a0f0a1282d67d549fe
		
	}
	
	

}
