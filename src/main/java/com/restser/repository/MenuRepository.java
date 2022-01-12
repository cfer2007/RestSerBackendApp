package com.restser.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>{
	@Query(value = "select distinct m.* \r\n"
			+ "from dish p, menu m \r\n"
			+ "where  p.id_menu=m.id_menu and \r\n"
			+ "p.id_restaurant = :id", nativeQuery = true)
	List<Menu> findByRestaurant(@Param("id") Long id);
}
