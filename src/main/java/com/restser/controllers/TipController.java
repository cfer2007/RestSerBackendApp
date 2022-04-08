package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restser.model.Tip;
import com.restser.repository.TipRepository;

@RestController
@RequestMapping("/tip")
public class TipController {
	
	@Autowired
	private TipRepository repo;
	
	@GetMapping("/{idReservation}")
	public List<Tip> getTipListByIdBranch(@PathVariable("idReservation") Long idReservation) {
		return repo.findByIdReservation(idReservation);
	}
}
