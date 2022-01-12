package com.restser.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "account")
@Table(name = "account", uniqueConstraints= 
@UniqueConstraint(columnNames = {"uid", "idReservation"}))
public class Account{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAccount;
	
	@ManyToOne
    @JoinColumn(name = "uid", nullable = true)
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "idReservation", nullable = true)	
	private Reservation reservation;
	
	@Column
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
