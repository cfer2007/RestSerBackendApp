package com.restser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.model.OrderReservation;

public interface OrderReservationRepository extends JpaRepository<OrderReservation, Long>{
	OrderReservation findByIdOrderReservation(Long id);
	//List<OrderReservation> findByIdReservation(Long idReservation);
	@Query(value="select distinct o_r.* \n"
			+ "from reservation r,\n"
			+ "order_reservation o_r\n"
			+ "where r.status = 'started'\n"
			+ "and r.id_reservation = o_r.id_reservation\n"
			+ "and r.uid = :uid", nativeQuery = true)
	List<OrderReservation> getOrderReservationActiveList(@Param("uid") String uid);
}
