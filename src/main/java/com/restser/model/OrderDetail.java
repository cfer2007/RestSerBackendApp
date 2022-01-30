package com.restser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="order_detail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idOrderDetail;
	
	@Column(length=10)
	private String status;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date date;
	
	@Column
	private Long idOrder;

	public long getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(long idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
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

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	
	
}
