package com.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.entity.Menu;
import com.ar.service.MenuService;
@RestController
@Controller
public class Apicontroller {
	
	@Autowired
	private MenuService menuService;
	
	public Apicontroller(MenuService menuService) {
		super();
		this.menuService = menuService;
	}

	@GetMapping("/all")
    public List<Menu> getAllMenu() {
        return menuService.getAllMenu();
    }

}
