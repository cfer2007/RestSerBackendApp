package com.restser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.model.Account;
import com.restser.model.Reservation;
import com.restser.model.User;

public interface AccountRepository extends JpaRepository<Account, Long>{

	
	List<Account> findByReservation(Reservation reservation);
	
	Account findByIdAccount(Long id);
	
	List<Account> findByUser(User user);
	
	@Query(value="select a.* \r\n"
			+ "from account a\r\n"
			+ "where a.id_reservation = :idReservation", nativeQuery = true)
	List<Account> findAccountListByIdReservation(@Param("idReservation")Long idReservation);
	
	
}
