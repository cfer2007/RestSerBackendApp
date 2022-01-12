package com.restser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.dto.AccountReservationDTO;
import com.restser.model.Account;
import com.restser.model.Reservation;
import com.restser.model.User;

public interface AccountRespository extends JpaRepository<Account, Long>{

	
	List<Account> findByReservation(Reservation reservation);
	
	Account findByIdAccount(Long id);
	
	List<Account> findByUser(User user);
	
	@Query(value="select r.id_reservation as idReservation,\r\n"
			+ "a.id_account as idAccount,\r\n"
			+ "r.status as status,\r\n"
			+ "r.start as date,\r\n"
			+ "r.id_table as idTable,\r\n"
			+ "r.uid as uidReservation,\r\n"
			+ "a.uid as uidAccount\r\n"
			+ "from reservation r,\r\n"
			+ "account a\r\n"
			+ "where a.id_reservation = r.id_reservation\r\n"
			+ "and a.uid =:id", nativeQuery = true)
	List<AccountReservationDTO> getReservationList(@Param("id") String id);
}
