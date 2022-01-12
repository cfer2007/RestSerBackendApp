package com.restser.dto;

public interface AccountReservationDTO {
	Long getIdReservation();
	Long getIdAccount();
	Long getUidReservation();
	Long getUidAccount();
	Long getIdTable();
	String getStatus();
	String getDate();
}
