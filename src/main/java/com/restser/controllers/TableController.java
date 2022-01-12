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

import com.restser.model.Tables;
import com.restser.repository.TableRepository;

@RestController
@RequestMapping("/table")
public class TableController {

	@Autowired
	private TableRepository repo;
	
	@GetMapping
	public List<Tables> getList(){
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Tables getTable(@PathVariable("id") Long id) {
		return repo.findByIdTable(id);
	}
	@PostMapping
	public Long setTable(@RequestBody Tables rest) {
		return repo.save(rest).getIdTable();
	}
	@PutMapping
	public void updateTable(@RequestBody Tables rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteTable(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
