package com.restser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tax {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idTax;
	
	@Column
	private String name;
	
	@Column(length=3)
	private int percentage;
	
	@ManyToOne
	@JoinColumn(name="idBranch",nullable = true)
	private Branch branch;

	public Long getIdTax() {
		return idTax;
	}

	public void setIdTax(Long idTax) {
		this.idTax = idTax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
