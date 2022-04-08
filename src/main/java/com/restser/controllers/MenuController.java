package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restser.model.Menu;
import com.restser.repository.MenuRepository;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuRepository repo;
	
	@GetMapping("/{id}")
	List<Menu> getListByRestaurant(@PathVariable("id") Long id){
		return (List<Menu>) repo.findByRestaurant(id);		
	}
}
