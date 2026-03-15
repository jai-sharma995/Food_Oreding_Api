package com.ar.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ar.SpringbootTesingApplication;
import com.ar.entity.Menu;
import com.ar.service.MenuService;

import jakarta.servlet.http.HttpSession;


@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	public MenuController(MenuService menuService) {
		super();
		this.menuService = menuService;

	}

	@GetMapping("/add")
	public String addMenuPage(Model model) {
		model.addAttribute("menu", new Menu());
		return "addMenu";
	}

	// SAVE MENU (restaurant auto mapped)
	@PostMapping("/addMenu")
	public String saveMenu(@ModelAttribute Menu menu,
	                       @RequestParam("imageFile") MultipartFile imageFile,
	                       HttpSession session) throws IOException {

	    // ✅ Session se restaurant name uthao
	    String restaurantName = (String) session.getAttribute("restaurantName");

	    // safety check
	    if (restaurantName == null) {
	        return "redirect:/login";
	    }

	   
	    menu.setRestaurantsName(restaurantName);

	   
	    if (!imageFile.isEmpty()) {
	        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
	        Path path = Paths.get("src/main/resources/static/uploads/" + fileName);
	        Files.createDirectories(path.getParent()); // important
	        Files.write(path, imageFile.getBytes());
	        menu.setImage("/uploads/" + fileName);
	    }

	   
	    menuService.saveMenu(menu);

	  
	    return "redirect:/list";
	}

	
	@GetMapping("/list")
    public String menuList(Model model, HttpSession session) {

		 String restaurantName = (String) session.getAttribute("restaurantName");
        
        model.addAttribute(
            "menuList",
            menuService.getMenuByRestaurant(restaurantName)
        );

        return "menuList";
    }
	
	
	
	@GetMapping("/menu")
    public String menuPage() {
        return "foodlist";   
    }

	@GetMapping("/Buttonmenu")
    public String menufache() {
        return "NormalApi";   
    }

	
	
}
