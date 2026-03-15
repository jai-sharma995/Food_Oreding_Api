package com.ar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.repo.UserDetailsrepo;
import com.ar.entity.UserDetails;
@Service
public class UserDetaileSerview {
	@Autowired
	private UserDetailsrepo userDetailsrepo;

	public UserDetaileSerview(UserDetailsrepo userDetailsrepo) {
		super();
		this.userDetailsrepo = userDetailsrepo;
	}
	
	public UserDetails saveDetails(UserDetails userDetails) {
		return userDetailsrepo.save(userDetails);	
	}
	
	

}
