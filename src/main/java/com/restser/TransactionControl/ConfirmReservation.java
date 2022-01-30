package com.restser.TransactionControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restser.model.Account;
import com.restser.model.OrderDish;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderDishRepository;
import com.restser.repository.OrderRepository;

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
	
	
	public void confirmReservation(String status,Reservation reservation) {
		statusControl.changeReservationStatus(status,reservation.getIdReservation());
		for(Account a: reservation.getListAccount()) {
			updateAccount(a.getIdAccount(),a);
			statusControl.changeOrderStatus(status, a.getListOrder());
			for(Orders o: a.getListOrder()) {
				updateOrder(o.getIdOrder(),o);
				for(OrderDish d: o.getListOrderDish()) {
					updateDishOrder(d.getIdOrderDish(),d);
				}
			}
		}		
	}
	
	public void updateAccount(Long idAccount, Account account) {
		Account a = repoAccount.findByIdAccount(idAccount);
		a.setSubtotal(account.getSubtotal());
		repoAccount.save(a);		
	}
	
	public void updateOrder(Long idOrder, Orders order) {
		Orders o = repoOrder.findByIdOrder(idOrder);
		o.setTotal_price(order.getTotal_price());
		o.setTotal_units(order.getTotal_units());
		repoOrder.save(o);
	}
	
	public void updateDishOrder(Long idDish, OrderDish dishOrder) {
		OrderDish d = repoDish.findByIdOrderDish(idDish);
		d.setUnits(dishOrder.getUnits());
		repoDish.save(d);
	}
}