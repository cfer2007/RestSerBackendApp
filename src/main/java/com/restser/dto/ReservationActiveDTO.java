package com.restser.dto;

import java.util.List;

import com.restser.model.Account;
import com.restser.model.Reservation;

public class ReservationActiveDTO {
	//private Long idReservation;
	private Reservation reservation;
	private List<Account> accountList;
	
	/*public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}*/
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
