package com.restser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="menu")
@Entity(name="menu")
public class Menu {

	@Id
	@Column(name="id_menu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMenu;	
	@Column(length=20)
	private String category;	
	@Column(length=100)
	private String description;
	@Column
	private String photo;	
	
	public long getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(long idMenu) {
		this.idMenu = idMenu;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
}
