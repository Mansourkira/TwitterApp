package org.ac.cst8277.mesak.nermeen.controller;

import java.util.ArrayList;
import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.ERole;
import org.ac.cst8277.mesak.nermeen.models.Role;
import org.ac.cst8277.mesak.nermeen.models.User;
import org.ac.cst8277.mesak.nermeen.repository.UserRepository;
import org.ac.cst8277.mesak.nermeen.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	// this function will get all users from database
	@GetMapping("/all")
	@ResponseBody
	public List<User> getAllUsers()
	{
		return (List<User>)userRepository.findAll();
	}
	
	
	
	// Get user by id:
	@GetMapping("/{userId}")
	@ResponseBody
	public User getUser(@PathVariable("userId") Long id)
	{			
		return (User)userRepository.findById(id).orElse(null);
	}

}
