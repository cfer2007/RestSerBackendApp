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

import com.restser.TransactionControl.StatusControl;
import com.restser.model.Account;
import com.restser.model.Orders;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository repo;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private StatusControl statusControl;
		
	@GetMapping
	public List<Orders> getAll(){
		return repo.findAll();
	}
	
	@GetMapping("/user/{uid}")
	public List<Orders> getOrdersByUser(@PathVariable("uid") String uid){
		return repo.getOrdersByUser(uid);
	}
	
	@GetMapping("/restaurant/{idRestaurant}")
	public List<Orders> getOrdersByRestaurant(@PathVariable("idRestaurant") Long idRestaurant){
		return repo.getOrdersByRestaurant(idRestaurant);
	}
	
	@PostMapping
	public  Long setOrder(@RequestBody Orders rest) {
		Long id = repo.save(rest).getIdOrder();
		Account account = accountRepo.findByIdAccount(rest.getAccount().getIdAccount());
		account.setSubtotal(account.getSubtotal()+rest.getTotal_price());
		accountRepo.save(account);	
		statusControl.setOrderLog(rest);
		return id;
	}
	@PutMapping
	public void updateOrder(@RequestBody Orders rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteOrder(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
	
	
}
