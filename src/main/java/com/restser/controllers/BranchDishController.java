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

import com.restser.dto.BranchDishDTO;
import com.restser.model.BranchDish;
import com.restser.repository.BranchDishRepository;

@RestController
@RequestMapping("/branch_dish")
public class BranchDishController {

	@Autowired
	private BranchDishRepository repo;
	
	@GetMapping
	List<BranchDish> getList(){
		return repo.findAll();
	}
	@GetMapping("/{branch}/{menu}")
	List<BranchDishDTO> listByBranch(@PathVariable("branch") Long branch, @PathVariable("menu") Long menu){
		return (List<BranchDishDTO>) repo.findByMenu(branch, menu);		
	}
	@PostMapping
	public void set(@RequestBody BranchDish rest) {
		repo.save(rest);
	}
	@PutMapping
	public void update(@RequestBody BranchDish rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
