package com.restser.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long>{
	@Query(value = "select * from sucursal s where s.id_restaurante = :id",nativeQuery = true)
	List<Branch> findByRestaurant(@Param("id") Long id);
}
