package com.restser.dto;

public interface OrderDishDTO {
	Long getIdOrderReservation();
	String getCurrency();
	Double getPrice();
	int getUnits();
	String getName();
}
