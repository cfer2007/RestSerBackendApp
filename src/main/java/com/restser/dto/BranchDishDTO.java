package com.restser.dto;


public interface BranchDishDTO {
	
	//sp.id_plato,sp.id_sucursal,p.nombre,p.descripcion,sp.moneda, sp.precio
	Long getIdDish();
	Long getIdBranch();
	String getName();
	String getDescription();
	String getCurrency();
	double getPrice();
	String getPhoto();
	
}
