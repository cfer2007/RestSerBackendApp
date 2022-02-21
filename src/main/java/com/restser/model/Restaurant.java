package com.restser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurant")
@Entity(name="restaurant")
public class Restaurant {

	@Id
	@Column(name="id_restaurant")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRestaurant;
	
	@Column(name= "name", length=100)
	private String name;
	
	@Column(name= "description", length=100)
	private String description;
	
	@Column(name= "address", length=150)
	private String address;
	
	@Column(name= "nit", length=20)
	private String NIT;
	
	@Column
	private String logo;
	
	public long getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(long idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}	
}
