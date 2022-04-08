package com.restser.model;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}