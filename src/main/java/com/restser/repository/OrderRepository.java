package com.restser.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.dto.OrderByStatusDTO;
import com.restser.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{
	
	Orders findByIdOrder(Long id);
	
	@Query(value="select distinct o.* \r\n"
			+ "from orders o,\r\n"
			+ "order_dish od\r\n"
			+ "where o.id_order = od.id_order\r\n"
			//+ "and o.status = 'started'\r\n"
			+ "and o.id_order_reservation is null\r\n"
			+ "and o.id_account = :idAccount", nativeQuery = true)
	List<Orders> getOrdersActiveByAccount(@Param("idAccount") Long idAccount);
	
	@Query(value="select ores.id_order_reservation as idOrderReservation, o.currency as currency, sum(o.total_price) as totalPrice, sum(o.total_units) as totalUnits, t.id_table as idTable\r\n"
			+ "	from orders o,\r\n"
			+ "	order_reservation ores, \r\n"
			+ "	reservation r, \r\n"
			+ "	tables t, \r\n"
			+ "	branch b\r\n"
			+ "	where o.id_order_reservation = ores.id_order_reservation\r\n"
			+ "	and r.id_reservation = ores.id_reservation \r\n"
			+ "	and t.id_table = r.id_table \r\n"
			+ "	and b.id_branch = t.id_branch \r\n"
			+ "	and b.id_branch = :idBranch \r\n"
			+ "	and ores.status = :status \r\n"
			+ "	and TO_DATE(ores.date, 'dd/mm/yyyy') = current_date \n"
			+ " group by ores.id_order_reservation, o.currency, t.id_table", nativeQuery = true)
	List<OrderByStatusDTO> getListOrdersByStatus(@Param("idBranch") Long idBranch, @Param("status") String status);
	
	@Query(value="select sum(total_price) total\r\n"
			+ "from orders\r\n"
			+ "where id_account = :idAccount\r\n"
			//+ "and status = 'confirmed'"
			+ "and id_order_reservation is not null"
			, nativeQuery = true)
	double getSubTotalByAccount(@Param("idAccount") Long idAccount);
	
	/*@Query(value="select o.*\r\n"
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
	List<Orders> getOrdersByRestaurant(@Param("idRestaurant") Long idRestaurant);*/
	
	/*@Query(value="select od.* \r\n"
			+ "from order_dish od,\r\n"
			+ "orders o,\r\n"
			+ "account a,\r\n"
			+ "reservation r\r\n"
			+ "where od.id_order = o.id_order\r\n"
			+ "and o.id_account = a.id_account\r\n"
			+ "and a.id_reservation = r.id_reservation\r\n"
			+ "and r.id_reservation =: idReservation", nativeQuery = true)
	List<Orders> getOrdersByReservation(@Param("idReservation") String idReservation);*/
	
}
