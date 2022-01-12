package com.restser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.dto.BranchDishDTO;
import com.restser.model.BranchDish;

public interface BranchDishRepository extends JpaRepository<BranchDish, Long>{
	
	@Query(value = "select bd.id_dish as idDish,bd.id_branch as idBranch,d.name as name,d.description as description,bd.currency as currency, bd.price as price, d.photo  as photo\r\n"
			+ "from dish d, branch b, branch_dish bd\r\n"
			+ "where d.id_dish=bd.id_dish \r\n"
			+ "and b.id_branch=bd.id_branch\r\n"
			+ "and b.id_branch=?1\r\n"
			+ "and d.id_menu =?2", nativeQuery = true)
	List<BranchDishDTO> findByMenu(@Param("sucursal")Long sucursal, @Param("menu")Long menu);
	
	
}
