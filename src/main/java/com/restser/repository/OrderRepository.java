package com.restser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{
	
	@Query(value="select o.* \r\n"
			+ "from orders o,\r\n"
			+ "account a,\r\n"
			+ "reservation r\r\n"
			+ "where o.id_account = a.id_account\r\n"
			+ "and r.id_reservation = a.id_reservation\r\n"
			+ "and a.uid =:uid", nativeQuery = true)
	List<Orders> getOrdersByUser(@Param("uid") String uid);
	
	@Query(value="select o.*\r\n"
			+ "from orders o,\r\n"
			+ "account a,\r\n"
			+ "reservation r,\r\n"
			+ "tables t,\r\n"
			+ "branch b\r\n"
			+ "where o.id_account = a.id_account\r\n"
			+ "and r.id_reservation = a.id_reservation\r\n"
			+ "and r.id_table = t.id_table\r\n"
			+ "and t. id_branch = b.id_branch\r\n"
			+ "and b.id_restaurant =:idRestaurant", nativeQuery = true)
	List<Orders> getOrdersByRestaurant(@Param("idRestaurant") Long idRestaurant);
}
