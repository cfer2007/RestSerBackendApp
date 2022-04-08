package com.restser.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.model.Tax;
import com.restser.repository.TaxRepository;

@RestController
@RequestMapping("/tax")
public class TaxController {
	
	@Autowired
	private TaxRepository repo;

	@GetMapping("/{idReservation}")
	public Tax getTaxListByIdBranch(@PathVariable("idReservation") Long idReservation) {
		return repo.findByIdReservation(idReservation);
	}
}
