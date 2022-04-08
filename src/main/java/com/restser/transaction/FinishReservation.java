package com.restser.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restser.model.Account;
import com.restser.model.OrderReservation;
import com.restser.model.Reservation;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderReservationRepository;
import com.restser.repository.ReservationRepository;

@Service
public class FinishReservation {
	
	@Autowired
	private AccountRepository repoAccount;
	@Autowired
	private OrderReservationRepository repoOR;
	@Autowired
	private ReservationRepository repoRes;
	
	public void finish(Long idReservation) {
		if(checkAccounts(idReservation) > 0) {
			//Devolver error, aun no se han pagado todas las cuentas
			System.out.println("cuentas pendientes de cobrar: ");
		}
		else {
			finishOrderReservation(idReservation);
			finishReservation(idReservation);
		}
	}
	
	public int checkAccounts(Long idReservation) {
		int cont =0;
		List<Account> listAccount = repoAccount.findAccountListByIdReservation(idReservation);
		for (Account account : listAccount) {
			if(!account.getStatus().equals("paid")) {
				cont++;
			}
		}
		return cont;
	}
	
	public void finishOrderReservation(Long idReservation) {
		List<OrderReservation> list = repoOR.findByIdReservation(idReservation);
		for (OrderReservation or : list) {
			or.setStatus("finished");
			repoOR.save(or);
		}
	}
	
	public void finishReservation(Long idReservation) {
		Reservation reservation = repoRes.findByIdReservation(idReservation);
		reservation.setFinish(null);
		reservation.setStatus("finished");
		repoRes.save(reservation);
	}
}
