package com.restser.transaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restser.model.Account;
import com.restser.model.OrderDish;
import com.restser.model.OrderReservation;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderDishRepository;
import com.restser.repository.OrderRepository;
import com.restser.repository.OrderReservationRepository;

@Service
public class ConfirmReservation {
	
	@Autowired
	private StatusControl statusControl;
	@Autowired
	private AccountRepository repoAccount;
	@Autowired
	private OrderRepository repoOrder;
	@Autowired
	private OrderDishRepository repoDish;
	@Autowired
	private OrderReservationRepository repoOR;
	
	Long idOrderReservation;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Calendar calendar = Calendar.getInstance();
	
	public void confirmReservation(Reservation reservation) {
		System.out.println("Status: "+reservation.getStatus());
		insertOrderReservation(reservation.getIdReservation(), reservation.getStatus());
		statusControl.changeOrderReservationStatus(reservation.getStatus(), idOrderReservation);
		for(Account a: reservation.getListAccount()) {
			updateAccount(a.getIdAccount(),a);
			for(Orders o: a.getListOrder()) {
				if(o.getStatus().equals("started")) {
					statusControl.changeOrderStatus(reservation.getStatus(), o);
					updateOrder(o.getIdOrder(),o,idOrderReservation);
					for(OrderDish d: o.getListOrderDish()) {
						updateDishOrder(d.getIdOrderDish(),d);
					}	
				}										
			}
		}		
	}
	
	public void insertOrderReservation(Long idReservation, String status) {
		System.out.println("insertOrderReservation");
		OrderReservation or = new OrderReservation();
		or.setIdReservation(idReservation);
		or.setStatus(status);
		or.setDate(formatter.format(calendar.getTime()));
		idOrderReservation = repoOR.save(or).getIdOrderReservation();
		
		
	}
	
	public void updateAccount(Long idAccount, Account account) {
		System.out.println("updateAccount");
		Account a = repoAccount.findByIdAccount(idAccount);
		a.setSubtotal(a.getSubtotal() + account.getSubtotal());
		if(a.getListOrder().size()>0)
			a.setCurrency(a.getListOrder().get(0).getCurrency());
		repoAccount.save(a);		
	}
	
	public void updateOrder(Long idOrder, Orders order, Long idOrderReservation) {
		System.out.println("updateOrder");
		Orders o = repoOrder.findByIdOrder(idOrder);
		o.setIdOrderReservation(idOrderReservation);
		o.setTotal_price(order.getTotal_price());
		o.setTotal_units(order.getTotal_units());
		repoOrder.save(o);
	}
	
	public void updateDishOrder(Long idDish, OrderDish dishOrder) {
		System.out.println("updateDishOrder");
		OrderDish d = repoDish.findByIdOrderDish(idDish);
		d.setUnits(dishOrder.getUnits());
		repoDish.save(d);
	}
}