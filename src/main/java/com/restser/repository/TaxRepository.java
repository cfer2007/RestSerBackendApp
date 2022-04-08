package com.restser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long>{

	@Query(value="select tax.*\n"
			+ "from tax tax,\n"
			+ "reservation r,\n"
			+ "tables t,\n"
			+ "branch b\n"
			+ "where r.id_reservation = :idReservation\n"
			+ "and r.id_table = t.id_table\n"
			+ "and t.id_branch = b.id_branch\n"
			+ "and tax.id_branch = b.id_branch", nativeQuery = true)
	Tax findByIdReservation(@Param("idReservation") Long idReservation);
}
