package com.restser.model.id;

import java.io.Serializable;

import javax.persistence.Column;

public class BranchDishId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "idBranch")
    private Long idBranch;

    @Column(name = "idDish")
    private Long idDish;

    public BranchDishId() {

    }

    public BranchDishId(Long idBranch, Long idDish) {
        this.idBranch = idBranch;
        this.idDish = idDish;
    }
}
