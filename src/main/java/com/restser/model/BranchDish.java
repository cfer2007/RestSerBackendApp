package com.restser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.restser.model.id.BranchDishId;

@Entity(name = "branch_dish")
@Table(name = "branch_dish")
@IdClass(BranchDishId.class)
public class BranchDish {
	@Id
    private Long idBranch;

    @Id
    private Long idDish;

    @Column(length=10)
    private double price;
    
    @Column(length = 2)
    private String currency;
    
    @ManyToOne
    @JoinColumn(name = "idBranch", referencedColumnName = "idBranch", insertable = false, updatable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "idDish", referencedColumnName = "idDish", insertable = false, updatable = false)
    private Dish dish;

    public BranchDish() {}

    public BranchDish(Long idBranch, Long idDish) {
        this.idBranch = idBranch;
        this.idDish = idDish;
    }

	public Long getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(Long idBranch) {
		this.idBranch = idBranch;
	}

	public Long getIdDish() {
		return idDish;
	}

	public void setIdDish(Long idDish) {
		this.idDish = idDish;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}	    
}
