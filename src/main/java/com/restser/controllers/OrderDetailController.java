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

import com.restser.model.OrderDish;
import com.restser.repository.OrderDetailRepository;

@RestController
@RequestMapping("/order_detail")
public class OrderDetailController {

	@Autowired
	private OrderDetailRepository repo;
	
	@GetMapping
	public List<OrderDish> getList(){
		return repo.findAll();
	}	
	@PostMapping
	public  void setOrderDetail(@RequestBody List<OrderDish> rest) {
		repo.saveAll(rest);
	}
	@PutMapping
	public void updateOrderDetail(@RequestBody OrderDish rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteOrderDetail(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
