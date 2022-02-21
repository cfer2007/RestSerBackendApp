package com.restser.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.dto.OrderDishDTO;
import com.restser.model.OrderDish;

public interface OrderDishRepository extends JpaRepository<OrderDish, Long>{
	OrderDish findByIdOrderDish(Long id);
	
	@Modifying()
	@Query(value = "delete from order_dish \r\n"
			+ "where id_order = :idOrder \r\n"
			+ "and id_order_dish not in (:dishes)", nativeQuery = true)
	@Transactional
	void deleteDishes(@Param("idOrder") Long idOrder, @Param("dishes") List<Long> dishes);
	
	@Query(value="select od.currency, sum(od.price) price, sum(od.units) units, od.name\r\n"
			+ "from order_dish od,\r\n"
			+ "orders o,\r\n"
			+ "order_reservation ores\r\n"
			+ "where od.id_order = o.id_order\r\n"
			+ "and ores.id_order_reservation = o.id_order_reservation\r\n"
			+ "and ores.id_order_reservation = :idOrderReservation\r\n"
			+ "group by od.name, od.id_dish, od.currency",nativeQuery=true)
	List<OrderDishDTO> getOrderDishListByIdReservation(@Param("idOrderReservation") Long idOrderReservation);
}
