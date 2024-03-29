package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restser.model.Account;
import com.restser.model.Reservation;
import com.restser.model.User;
import com.restser.repository.AccountRepository;
import com.restser.transaction.CollectAccounts;
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository repo;
	@Autowired
	private CollectAccounts collectAccounts;
		
	//obtiene todas las cuentas asociadas a un cliente
	@GetMapping("/listByUid/{id}")
	public List<Account> getAccountListByUid(@PathVariable("id") String uid) {
		User user = new User();
		user.setUid(uid);
		return repo.findByUser(user);
	}
	//obtiene las cuentas asociadas a una reservacion
	@GetMapping("/listByIdReservation/{id}")
	public List<Account> getAccountListByIdReservation(@PathVariable("id") Long idReservation) {
		Reservation res = new Reservation();
		res.setIdReservation(idReservation);
		return repo.findByReservation(res);
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable("id") Long idAccount) {
		return repo.findByIdAccount(idAccount);
	}
	
	
	@PostMapping("/list/{status}")
	public void setAccounts(@RequestBody List<Account> rest, @PathVariable("status") String status) {
		for (Account account : rest) {
			account.setStatus(status);
			repo.save(account);
		}
		//repo.saveAll(rest);		
	}
	
	@PostMapping
	public Long setAccount(@RequestBody Account rest) {
		return repo.save(rest).getIdAccount();		
	}
	
	@PutMapping("/{idReservation}/{status}")
	public void collectAccounts(@RequestBody List<Account> listAccount, @PathVariable("idReservation") Long idReservation, @PathVariable("status") String status) {
		collectAccounts.updateAccounts(listAccount, idReservation, status);
	}
	
	@PutMapping("/{idAccount}/{status}")
	public void chargeAccount(@PathVariable("idAccount") Long idAccount, @PathVariable("status") String status) {
		Account a = repo.findByIdAccount(idAccount);
		a.setStatus(status);
		repo.save(a);
	}
}
