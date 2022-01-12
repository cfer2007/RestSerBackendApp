package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.model.Menu;
import com.restser.repository.MenuRepository;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuRepository repo;
	
	@GetMapping
	List<Menu> getList(){
		return repo.findAll();
	}
	@GetMapping("/{id}")
	List<Menu> getListByRestaurant(@PathVariable("id") Long id){
		return (List<Menu>) repo.findByRestaurant(id);		
	}
	@PostMapping
	public void setMenu(@RequestBody Menu rest) {
		repo.save(rest);
	}
	@PutMapping
	public void updateMenu(@RequestBody Menu rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteMenu(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
