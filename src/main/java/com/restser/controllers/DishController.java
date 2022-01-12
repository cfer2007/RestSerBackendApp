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

import com.restser.model.Dish;
import com.restser.repository.DishRepository;

@RestController
@RequestMapping("/dish")
public class DishController {
	
	@Autowired
	private DishRepository repo;
	
	@GetMapping
	List<Dish> getList(){
		return repo.findAll();
	}
	@PostMapping
	public void setCourse(@RequestBody Dish rest) {
		repo.save(rest);
	}
	@PutMapping
	public void updateCourse(@RequestBody Dish rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteCourse(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
