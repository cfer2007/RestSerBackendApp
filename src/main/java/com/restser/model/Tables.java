package com.restser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tables")
public class Tables {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTable;
	
	@Column(length=3)
	private int size;
	
	@Column(length=20)
	private String location;
	
	@Column(length=10)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="idBranch",referencedColumnName = "idBranch",nullable = true)
	private Branch branch;	

	public Long getIdTable() {
		return idTable;
	}

	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
