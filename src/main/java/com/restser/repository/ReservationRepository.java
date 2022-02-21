package com.restser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.dto.ReservationDTO;
import com.restser.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	Reservation findByIdReservation(Long id);
	
	@Query(value="select r.id_reservation as idReservation, r.start, r.finish,a.currency, a.subtotal\r\n"
			+ "from reservation r,\r\n"
			+ "account a\r\n"
			+ "where r.id_reservation = a.id_reservation\r\n"
			//+ "and subtotal > 0\r\n"
			+ "and r.status = 'finished'\r\n"
			+ "and a.uid = :uid \r\n", nativeQuery = true)
	List<ReservationDTO> getFinishReservationList(@Param("uid") String uid);
	
	/*@Query(value="select id_reservation, finish, \"start\", status, id_table, uid\r\n"
			+ "from reservation\r\n"
			+ "where uid = :uid \r\n"
			+ "and status = 'started'", nativeQuery = true)
	List<Reservation> getReservationsActive(@Param("uid") String uid);*/
	
	@Query(value="select id_reservation\r\n"
			+ "from reservation\r\n"
			+ "where uid = :uid \r\n"
			+ "and status = 'started'", nativeQuery = true)
	List<Long> getReservationsActive(@Param("uid") String uid);
	
	@Query(value="select r.* \r\n"
			+ "from reservation r\r\n"
			+ "where r.uid = :uid \r\n"
			+ "and r.status = 'started'", nativeQuery = true)
	Reservation getActiveReservation(@Param("uid") String uid);
}
