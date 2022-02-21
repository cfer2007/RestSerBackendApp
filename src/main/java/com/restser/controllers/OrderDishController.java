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
import com.restser.dto.OrderDishDTO;
import com.restser.model.OrderDish;
import com.restser.repository.OrderDishRepository;

@RestController
@RequestMapping("/order_dish")
public class OrderDishController {

	@Autowired
	private OrderDishRepository repo;
	
	@GetMapping
	public List<OrderDish> getList(){
		return repo.findAll();
	}
	@GetMapping("/list/{idReservation}")
	public List<OrderDishDTO> getOrderDishListByIdReservation(@PathVariable("idReservation") Long idReservation){
		return repo.getOrderDishListByIdReservation(idReservation);
	}	
	
	@PostMapping
	public  void setOrderDish(@RequestBody List<OrderDish> rest) {
		repo.saveAll(rest);
	}
	@PutMapping
	public void updateOrderDish(@RequestBody OrderDish rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteOrderDish(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
