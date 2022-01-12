package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.AccountReservationDTO;
//import com.restser.dto.StatusReservationDTO;
import com.restser.model.Reservation;
//import com.restser.model.ReservationDetail;
//import com.restser.repository.ReservationLogRepository;
import com.restser.repository.ReservationRepository;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository repo;
	/*@Autowired
	private ReservationLogRepository repoLog;*/
	
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
		//setLog(rest);
		return id;
	}
	/*@PutMapping
	public void updateStatus(@RequestBody StatusReservationDTO rest) {
		repo.save(rest);
	}*/
	
	
	@DeleteMapping(value="/{id}")
	public void deleteReservation(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
	
	/*private void setLog(Reservation res) {
		ReservationDetail det = new ReservationDetail();
		det.setDate(res.getStart());
		det.setStatus(res.getStatus());
		det.setReservation(res);
		repoLog.save(det);
	}*/
}
