package com.restser.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.restser.model.OrderDish;

public interface OrderDishRepository extends JpaRepository<OrderDish, Long>{
	OrderDish findByIdOrderDish(Long id);
	
	@Modifying()
	@Query(value = "delete from order_dish \r\n"
			+ "where id_order = :idOrder \r\n"
			+ "and id_order_dish not in (:dishes)", nativeQuery = true)
	@Transactional
	void deleteDishes(@Param("idOrder") Long idOrder, @Param("dishes") List<Long> dishes);
}
