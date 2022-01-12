package com.restser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_detail")
public class TableDetail {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTableDetail;	
	
	@Column(length=10)
	private String status;
	
	@Column
	private Date date;

	public Long getIdTableDetail() {
		return idTableDetail;
	}

	public void setIdTableDetail(Long idTableDetail) {
		this.idTableDetail = idTableDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
