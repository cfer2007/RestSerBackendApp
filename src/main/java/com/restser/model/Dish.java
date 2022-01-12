package com.restser.model;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "dish")
@Table(name = "dish")
public class Dish implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Dish() {}   

    public Dish(String name) {
    	super();
        this.name = name;
    }
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idDish;

	@Column(length=50)
    private String name;
	
	@Column(length=100)
	private String description;
    
    @Column
	private String photo;
    
    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = true)
    private Restaurant restaurant; 
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dish")  
    private List<BranchDish> branchCourse = new ArrayList<>();   
	
	@JsonIgnore
	public List<BranchDish> getBranchCourse() {
		return branchCourse;
	}

	public void setBranchCourse(List<BranchDish> branchCourse) {
		this.branchCourse = branchCourse;
	}
	
	@ManyToOne
    @JoinColumn(name = "id_menu", nullable = true)
    private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Long getIdDish() {
		return idDish;
	}

	public void setIdDish(Long idDish) {
		this.idDish= idDish;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
