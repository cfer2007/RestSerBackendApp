package com.restser.dto;

public interface ReservationDTO {
	Long getIdReservation();
	String getStart();
	String getFinish();
	String getCurrency();
	Double getSubtotal();
}
