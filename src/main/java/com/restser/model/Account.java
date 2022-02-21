package com.restser.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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
	
	@Column
	//@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private String date;
	
	@Column(length=2)
	private String currency;
	
	@Column
	private double subtotal;
	
	@OneToMany(mappedBy="account", fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Orders> listOrder;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="idReservation")
	private Reservation reservation;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public List<Orders> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Orders> listOrder) {
		this.listOrder = listOrder;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
