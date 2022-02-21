package com.restser.dto;

import java.util.List;

import com.restser.model.OrderReservation;

public class DishesByOrderReservationDTO {
	//Long idOrderReservation;
	OrderReservation orderReservation;
	List<OrderDishDTO> orderDishList;
	
	/*public Long getIdOrderReservation() {
		return idOrderReservation;
	}
	public void setIdOrderReservation(Long idOrderReservation) {
		this.idOrderReservation = idOrderReservation;
	}*/
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
