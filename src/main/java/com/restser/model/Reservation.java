package com.restser.model;

import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name="reservation")
@Entity(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReservation;
	
	@Column(length=10)
	private String status;
	
	@Column
	//@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private String start;
	
	@Column
	private Date finish;
	
	@ManyToOne
    @JoinColumn(name = "uid", nullable = true)
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "idTable", nullable = true)
    private Tables table;

	@OneToMany(mappedBy="reservation", fetch = FetchType.EAGER)
	@JsonManagedReference//(value="account")
    private List<Account> listAccount;
	
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

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}	
}
