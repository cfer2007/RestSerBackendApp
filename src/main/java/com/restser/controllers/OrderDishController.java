package com.restser.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.OrderDishDTO;
import com.restser.model.OrderDish;
import com.restser.repository.OrderDishRepository;

@RestController
@RequestMapping("/order_dish")
public class OrderDishController {

	@Autowired
	private OrderDishRepository repo;
	
	@PostMapping
	public  void setOrderDish(@RequestBody List<OrderDish> rest) {
		repo.saveAll(rest);
	}
	@GetMapping("/list/{idOrderReservation}")
	public List<OrderDishDTO> getOrderDishListByIdOrderReservation(@PathVariable("idOrderReservation") Long idOrderReservation){
		return repo.getOrderDishListByIdOrderReservation(idOrderReservation);
	}
}
 