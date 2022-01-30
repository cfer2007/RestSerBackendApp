package com.restser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="reservation_detail")
public class ReservationDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idReservationDetail;
	
	@Column(length=10)
	private String status;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date date;
	
	@Column(length=100)
	private String description;
	
	@Column
	private Long idReservation;

	public long getIdReservationDetail() {
		return idReservationDetail;
	}

	public void setIdReservationDetail(long idReservationDetail) {
		this.idReservationDetail = idReservationDetail;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
}
