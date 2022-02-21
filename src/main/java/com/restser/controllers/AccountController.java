package com.restser.controllers;

//import java.util.ArrayList;
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

//import com.restser.dto.OrdersActiveDTO;
import com.restser.model.Account;
//import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.model.User;
import com.restser.repository.AccountRepository;
//import com.restser.repository.OrderRepository;
//import com.restser.repository.ReservationRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository repo;
	/*@Autowired
	private OrderRepository oRepo;
	@Autowired
	private ReservationRepository Resrepo;*/
		
	@GetMapping
	public List<Account> getList(){
		return repo.findAll();
	}
	//obtiene todas las cuentas asociadas a un cliente
	@GetMapping("/list/{id}")
	public List<Account> getAccountList(@PathVariable("id") String uid) {
		User user = new User();
		user.setUid(uid);
		return repo.findByUser(user);
	}
	//obtiene las cuentas asociadas a una reservacion
	@GetMapping("/reservation/{id}")
	public List<Account> getAccounts(@PathVariable("id") Long idReservation) {
		Reservation res = new Reservation();
		res.setIdReservation(idReservation);
		return repo.findByReservation(res);
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable("id") Long idAccount) {
		return repo.findByIdAccount(idAccount);
	}
	
	@PostMapping("/list")
	public void setAccounts(@RequestBody List<Account> rest) {
		repo.saveAll(rest);		
	}
	
	@PostMapping
	public Long setAccount(@RequestBody Account rest) {
		return repo.save(rest).getIdAccount();		
	}
	
	@PutMapping
	public void updateAccount(@RequestBody Account rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteAccount(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
