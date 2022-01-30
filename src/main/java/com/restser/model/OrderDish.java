package com.restser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "order_dish")
@Table(name = "order_dish")
public class OrderDish implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrderDish;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="id_order")
	private Orders order;
	
	@Column
	private Long idDish;
	
	@Column(length=50)
	private String name;
	
	@Column(length=2)
	private String currency;
	
	@Column(length=10)
	private double price;
	
	@Column(length=4)
	private int units;

	public Long getIdOrderDish() {
		return idOrderDish;
	}

	public void setIdOrderDish(Long idOrderDish) {
		this.idOrderDish = idOrderDish;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Long getIdDish() {
		return idDish;
	}

	public void setIdDish(Long idDish) {
		this.idDish = idDish;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	
	
	
}
