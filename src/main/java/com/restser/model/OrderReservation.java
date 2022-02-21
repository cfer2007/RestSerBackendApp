package com.restser.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="order_reservation")
@Table(name="order_reservation")
public class OrderReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrderReservation;
	
	@Column
	private Long idReservation;
	
	@Column
	private String status;
	
	@Column
	//@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private String date;
	
	@OneToMany(mappedBy="orderReservation", fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<OrderReservationDetail> listOrderReservation;
	
	public Long getIdOrderReservation() {
		return idOrderReservation;
	}
	public void setIdOrderReservation(Long idOrderReservation) {
		this.idOrderReservation = idOrderReservation;
	}
	
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
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
	public List<OrderReservationDetail> getListOrderReservation() {
		return listOrderReservation;
	}
	public void setListOrderReservation(List<OrderReservationDetail> listOrderReservation) {
		this.listOrderReservation = listOrderReservation;
	}
}