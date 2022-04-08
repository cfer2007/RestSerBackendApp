package com.restser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.OrderByStatusDTO;
import com.restser.model.Orders;
import com.restser.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository repo;
			
	@PostMapping
	public  Long setOrder(@RequestBody Orders rest) {
		Long id = repo.save(rest).getIdOrder();
		return id;
	}
	@GetMapping("/listByStatus/{idBranch}/{status}")
	public List<OrderByStatusDTO> getListOrdersByStatus(@PathVariable("idBranch") Long idBranch, @PathVariable("status") String status){
		return repo.getListOrdersByStatus(idBranch, status);
	}
}
