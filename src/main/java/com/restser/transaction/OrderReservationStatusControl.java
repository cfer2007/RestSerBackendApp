package com.restser.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import com.restser.model.Account;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.repository.OrderReservationRepository;
import com.restser.repository.ReservationRepository;*/

@Service
public class OrderReservationStatusControl {
	
	@Autowired
	private StatusControl statusControl;
	/*@Autowired
	private OrderReservationRepository repoOR;
	@Autowired
	private ReservationRepository repoRes;*/
	
	public void changeStatus(Long idOrderReservation, String status) {
		statusControl.changeOrderReservationStatus(status, idOrderReservation);
		/*Reservation reservation = repoRes.findByIdReservation(repoOR.findByIdOrderReservation(idOrderReservation).getIdReservation());
		for(Account a: reservation.getListAccount()) {
			for(Orders o: a.getListOrder()) {
				statusControl.changeOrderStatus(status, o);
			}
		}*/		
	}
}
