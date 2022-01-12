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

import com.restser.model.Branch;
import com.restser.repository.BranchRepository;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchRepository repo;
	
	@GetMapping
	List<Branch> getList(){
		return repo.findAll();
	}
	@PostMapping
	public void setBranch(@RequestBody Branch rest) {
		repo.save(rest);
	}
	@PutMapping
	public void updateBranch(@RequestBody Branch rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteBranch(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
