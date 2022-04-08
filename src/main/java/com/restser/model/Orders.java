package com.restser.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="orders")
@Table(name="orders")
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrder;
	@Column
	//@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private String date;
	
	@Column(length=100)
	private String comment;
	
	/*@Column(length=10)
	private String status;*/
	
	@Column(length=2)
	private String currency;
	
	@Column(length=10)
	private double total_price;
	
	@Column(length=4)
	private int total_units;
	
	@Column
	private Long idOrderReservation;
	

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="id_account")
	private Account account;
	
	@OneToMany(mappedBy="order", fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<OrderDish> listOrderDish;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/*public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}*/

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getTotal_units() {
		return total_units;
	}

	public void setTotal_units(int total_units) {
		this.total_units = total_units;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<OrderDish> getListOrderDish() {
		return listOrderDish;
	}

	public void setListOrderDish(List<OrderDish> listOrderDish) {
		this.listOrderDish = listOrderDish;
	}

	public Long getIdOrderReservation() {
		return idOrderReservation;
	}

	public void setIdOrderReservation(Long idOrderReservation) {
		this.idOrderReservation = idOrderReservation;
	}
	

	/*public OrderReservation getOrderReservation() {
		return orderReservation;
	}

	public void setOrderReservation(OrderReservation orderReservation) {
		this.orderReservation = orderReservation;
	}*/
	
	
}
