package com.restser.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restser.model.Account;
import com.restser.model.OrderReservation;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderReservationRepository;

@Service
public class CollectAccounts {
	
	@Autowired
	private AccountRepository repo;
	@Autowired
	private StatusControl statusControl;
	@Autowired
	private OrderReservationRepository orRepo;
	
	public void updateAccounts(List<Account> list, Long idReservation, String status) {
		updateOrderReservation(idReservation,status);
		for (Account account : list) {
			updateAccount(account, status);
			
			/*for(Orders o: account.getListOrder()) {
				statusControl.changeOrderStatus(status, o);
			}*/
		}
	}
	
	public void updateAccount(Account a, String status) {
		System.out.println("idAccount: "+ a.getIdAccount());
		Account account = repo.findByIdAccount(a.getIdAccount());
		if(a.getTotal() != account.getTotal()) {
			account.setTip_percentage(a.getTip_percentage());
			account.setTip(a.getTip());
			account.setTotal(a.getTotal());		
			account.setStatus(status);
			repo.save(account);
			
		}
	}
	
	public void updateOrderReservation(Long idReservation, String status) {
		List<OrderReservation> list = orRepo.getOrderReservationByIdReservation(idReservation);
		for (OrderReservation orderReservation : list) {
			statusControl.changeOrderReservationStatus(status, orderReservation.getIdOrderReservation());
		}
	}
}
