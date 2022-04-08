package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.BranchDishDTO;
import com.restser.repository.BranchDishRepository;

@RestController
@RequestMapping("/branch_dish")
public class BranchDishController {

	@Autowired
	private BranchDishRepository repo;
	
	@GetMapping("/{branch}/{menu}")
	List<BranchDishDTO> listByBranch(@PathVariable("branch") Long branch, @PathVariable("menu") Long menu){
		return (List<BranchDishDTO>) repo.findByMenu(branch, menu);		
	}
}
