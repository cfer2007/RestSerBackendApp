package com.restser.dto;

import java.util.List;

import com.restser.model.Account;

public class ReservationActiveDTO {
	private Long idReservation;
	private List<Account> accountList;
	
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}	
}
