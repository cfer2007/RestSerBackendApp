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
import com.restser.model.Orders;
import com.restser.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository repo;
			
	@GetMapping
	public List<Orders> getAll(){
		return repo.findAll();
	}
	//temp
	@GetMapping("/{idAccount}")
	public List<Orders> getOrdersActiveByAccount(@PathVariable("idAccount") Long idAccount){
		return repo.getOrdersActiveByAccount(idAccount);
	}	
	@PostMapping
	public  Long setOrder(@RequestBody Orders rest) {
		Long id = repo.save(rest).getIdOrder();
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
