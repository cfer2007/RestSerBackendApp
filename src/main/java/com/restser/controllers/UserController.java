package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.model.User;
import com.restser.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/{id}")
	public List<User> getListWithOutDuplicate(@PathVariable("id") String id){
		return repo.findWithOutDuplicate(id);
	}
	@PostMapping
	public void setGoogleUser(@RequestBody User user) {
		System.out.println("ädfas");
		repo.save(user);
	}
}
