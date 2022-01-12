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

@Entity
@Table(name = "branch")
public class Branch implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Branch() {
    }

    public Branch(String name) {
        super();
        this.name = name;
    }	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBranch;

	@Column(length=50)
    private String name;
	
	@Column(length=150)
	private String address;
	
	@Column(length=15)
	private String phone;
	
	@ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = true)
    private Restaurant restaurant;
	
	public Long getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(Long idBranch) {
		this.idBranch = idBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
