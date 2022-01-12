package com.restser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idOrderLog;
	
	@Column(length=10)
	private String status;
	
	@Column
	private Date date;
	
	@ManyToOne
    @JoinColumn(name = "idOrder", nullable = true)
	private Orders order;

	public long getIdOrderLog() {
		return idOrderLog;
	}

	public void setIdOrderLog(long idOrderLog) {
		this.idOrderLog = idOrderLog;
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

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
}
