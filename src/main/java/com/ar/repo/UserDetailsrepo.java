package com.ar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ar.entity.UserDetails;

public interface UserDetailsrepo extends JpaRepository<UserDetails,Integer>  {
<<<<<<< HEAD
	UserDetails findByMobilenoAndPassword(String mobileno, String password);
=======

>>>>>>> 38d640902c8213dfea6914a0f0a1282d67d549fe
}
