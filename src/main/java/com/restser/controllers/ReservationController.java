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

import com.restser.TransactionControl.ConfirmReservation;
import com.restser.TransactionControl.StatusControl;
import com.restser.dto.AccountReservationDTO;
import com.restser.model.Reservation;
import com.restser.repository.ReservationRepository;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository repo;
	@Autowired
	private ConfirmReservation reservationControl;
	@Autowired
	private StatusControl statusControl;
	
	@GetMapping
	public List<Reservation> getList(){
		return repo.findAll();
	}
	@GetMapping("/list/{id}")
	public List<AccountReservationDTO> getReservationList(@PathVariable("id") String id){
		return repo.getReservationList(id);		
	}
	@GetMapping("/{id}")
	public Reservation getReservation(@PathVariable("id") Long id){
		return repo.findByIdReservation(id);		
	}
	@PostMapping
	public Long setReservation(@RequestBody Reservation rest) {
		System.out.println("uid: "+rest.getUser().getUid());
		Long id = repo.save(rest).getIdReservation();
		rest.setIdReservation(id);
		statusControl.setReservationLog(rest);
		return id;
	}
	@PutMapping
	public void confirmReservation(@RequestBody Reservation rest) {
		reservationControl.confirmReservation(rest.getStatus(), rest);
	}	
	
	
	@DeleteMapping(value="/{id}")
	public void deleteReservation(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
	
	
}
