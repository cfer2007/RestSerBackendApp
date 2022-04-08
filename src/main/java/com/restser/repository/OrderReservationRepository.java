package com.restser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.dto.OrdersCount;
import com.restser.model.OrderReservation;

public interface OrderReservationRepository extends JpaRepository<OrderReservation, Long>{
	OrderReservation findByIdOrderReservation(Long id);
	List<OrderReservation> findByIdReservation(Long idReservation);
	@Query(value="select distinct o_r.* \n"
			+ "from reservation r,\n"
			+ "order_reservation o_r\n"
			+ "where r.status = 'started'\n"
			+ "and r.id_reservation = o_r.id_reservation\n"
			+ "and r.uid = :uid", nativeQuery = true)
	List<OrderReservation> getOrderReservationActiveList(@Param("uid") String uid);
	
	@Query(value="select ors.status status, coalesce(a.total,0) total \n"
			+ "from (\n"
			+ "	select ores.status, count(ores.status) total \n"
			+ "	from order_reservation ores, \n"
			+ "	reservation r, \n"
			+ "	tables t, \n"
			+ "	branch b\n"
			+ "	where r.id_reservation = ores.id_reservation \n"
			+ "	and t.id_table = r.id_table \n"
			+ "	and b.id_branch = t.id_branch \n"
			+ "	and b.id_branch = ? \n"
			+ "	and TO_DATE(ores.date, 'dd/mm/yyyy') = current_date \n"
			+ "	group by ores.status \n"
			+ ") a\n"
			+ "right join order_reservation_status ors\n"
			+ "on ors.status = a.status\n"
			+ "group by ors.status, a.total\n"
			+ "order by ors.status", nativeQuery = true)
	List<OrdersCount> getOrderReservationCount(@Param("idBranch") Long idBranch);
	
	@Query(value="select distinct o_r.* \n"
			+ "from reservation r,\n"
			+ "order_reservation o_r\n"
			+ "where r.status = 'started'\n"
			+ "and r.id_reservation = o_r.id_reservation\n"
			+ "and r.id_reservation = :idReservation", nativeQuery = true)
	List<OrderReservation> getOrderReservationByIdReservation(Long idReservation);
}
