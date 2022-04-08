package com.restser.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.DishesByOrderReservationDTO;
import com.restser.dto.OrderDishDTO;
import com.restser.dto.OrdersCount;
import com.restser.model.OrderReservation;
import com.restser.repository.OrderDishRepository;
import com.restser.repository.OrderReservationRepository;
import com.restser.transaction.OrderReservationStatusControl;

@RestController
@RequestMapping("/order_reservation")
public class OrderReservationController {

	@Autowired
	private OrderDishRepository repo;
	@Autowired
	private OrderReservationRepository ORrepo;
	@Autowired
	private OrderReservationStatusControl orControl;
	
	@GetMapping("/list/{uid}")
	public List<DishesByOrderReservationDTO> getDishesListByIdReservation(@PathVariable("uid") String uid){
		List<DishesByOrderReservationDTO> listDishesByOrderReservation = new ArrayList<DishesByOrderReservationDTO>();
		List<OrderReservation> orderReservationList = ORrepo.getOrderReservationActiveList(uid);
		for(OrderReservation or: orderReservationList) {
			DishesByOrderReservationDTO data = new DishesByOrderReservationDTO();
			List<OrderDishDTO> dishes = repo.getOrderDishListByIdOrderReservation(or.getIdOrderReservation());
			data.setOrderReservation(or);
			data.setOrderDishList(dishes);			
			listDishesByOrderReservation.add(data);
		}
		return listDishesByOrderReservation;
	}
	@GetMapping("/orderReservationCount/{idBranch}")
	public List<OrdersCount> getOrderReservationCount(@PathVariable("idBranch") Long idBranch){
		return ORrepo.getOrderReservationCount(idBranch);
	}
	@PutMapping("/{idOrderReservation}/{status}")
	public void confirmReservation(@PathVariable("idOrderReservation") Long idOrderReservation, @PathVariable("status") String status) {
		orControl.changeStatus(idOrderReservation, status);
	}	
}
