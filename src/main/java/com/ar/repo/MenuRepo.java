package com.ar.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ar.entity.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> {
	
	List<Menu> findByRestaurantsName(String restaurantsName);

}
