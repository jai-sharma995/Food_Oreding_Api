package com.ar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ar.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	
	 Restaurant findByUsernameAndPassword(String username, String password);

	    boolean existsByUsername(String username);
	    

}
