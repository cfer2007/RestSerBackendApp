package com.restser.dto;

import java.util.List;

import com.restser.model.OrderReservation;

public class DishesByOrderReservationDTO {
	OrderReservation orderReservation;
	List<OrderDishDTO> orderDishList;
		
	public OrderReservation getOrderReservation() {
		return orderReservation;
	}
	public void setOrderReservation(OrderReservation orderReservation) {
		this.orderReservation = orderReservation;
	}
	public List<OrderDishDTO> getOrderDishList() {
		return orderDishList;
	}
	public void setOrderDishList(List<OrderDishDTO> orderDishList) {
		this.orderDishList = orderDishList;
	}
	
}
