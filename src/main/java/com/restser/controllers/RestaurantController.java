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

import com.restser.model.Restaurant;
import com.restser.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository repo;
	
	@GetMapping
	List<Restaurant> getList(){
		return repo.findAll();
	}
	@PostMapping
	public void setRestaurante(@RequestBody Restaurant rest) {
		repo.save(rest);
	}
	@PutMapping
	public void updateRestaurante(@RequestBody Restaurant rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteRestaurante(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}	
}
