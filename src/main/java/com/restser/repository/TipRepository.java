package com.restser.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.model.Tip;

public interface TipRepository extends JpaRepository<Tip, Long>{

	@Query(value="select tip.*\n"
			+ "from tip tip,\n"
			+ "reservation r,\n"
			+ "tables t,\n"
			+ "branch b\n"
			+ "where r.id_reservation = :idReservation\n"
			+ "and r.id_table = t.id_table\n"
			+ "and t.id_branch = b.id_branch\n"
			+ "and tip.id_branch = b.id_branch", nativeQuery = true)
	List<Tip> findByIdReservation(@Param("idReservation") Long idReservation);
	
	@Query(value="select tip.*\n"
			+ "from tip tip,\n"
			+ "reservation r,\n"
			+ "tables t,\n"
			+ "branch b\n"
			+ "where r.id_reservation = :idReservation\n"
			+ "and tip.name='default'\n"
			+ "and r.id_table = t.id_table\n"
			+ "and t.id_branch = b.id_branch\n"
			+ "and tip.id_branch = b.id_branch", nativeQuery = true)
	Tip findDefaultTipByIdReservation(@Param("idReservation") Long idReservation);
}
