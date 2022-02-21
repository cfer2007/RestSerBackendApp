package com.restser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="order_reservation_detail")
public class OrderReservationDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idOrderReservationDetail;
	
	@Column(length=10)
	private String status;
	
	@Column
	private String date;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="id_order_reservation")
	private OrderReservation orderReservation;

	public long getIdOrderReservationDetail() {
		return idOrderReservationDetail;
	}

	public void setIdOrderReservationDetail(long idOrderReservationDetail) {
		this.idOrderReservationDetail = idOrderReservationDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public OrderReservation getOrderReservation() {
		return orderReservation;
	}

	public void setOrderReservation(OrderReservation orderReservation) {
		this.orderReservation = orderReservation;
	}	
}
