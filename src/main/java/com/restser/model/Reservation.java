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

@Table(name="reservation")
@Entity(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idReservation;
	
	@Column(length=10)
	private String status;
	
	@Column
	private Date start;
	
	@Column
	private Date finish;
	
	@ManyToOne
    @JoinColumn(name = "uid", nullable = true)
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "idTable", nullable = true)
    private Tables table;



	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tables getTable() {
		return table;
	}

	public void setTable(Tables table) {
		this.table = table;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}
}
