package com.restser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.model.Tables;
import com.restser.repository.TableRepository;

@RestController
@RequestMapping("/table")
public class TableController {

	@Autowired
	private TableRepository repo;
	
	@GetMapping("/{id}")
	public Tables getTable(@PathVariable("id") Long id) {
		return repo.findByIdTable(id);
	}
}
