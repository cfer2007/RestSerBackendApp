package com.restser.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restser.model.Account;
import com.restser.model.OrderDish;
import com.restser.model.OrderReservation;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.model.Tax;
import com.restser.model.Tip;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderDishRepository;
import com.restser.repository.OrderRepository;
import com.restser.repository.OrderReservationRepository;
//import com.restser.repository.ReservationRepository;
import com.restser.repository.TaxRepository;
import com.restser.repository.TipRepository;

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
	//@Autowired
	//private ReservationRepository repoRes;
	@Autowired
	private TaxRepository repoTax;
	@Autowired
	private TipRepository repoTip;
	
	Long idOrderReservation;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public void confirmReservation(Reservation reservation) {
		insertOrderReservation(reservation.getIdReservation(), reservation.getStatus());
		statusControl.changeOrderReservationStatus(reservation.getStatus(), idOrderReservation);
		for(Account a: reservation.getListAccount()) {			
			for(Orders o: a.getListOrder()) {
				//if(o.getStatus().equals("started")) {
				if(o.getIdOrderReservation() == null) {
					//statusControl.changeOrderStatus(reservation.getStatus(), o);
					updateOrder(o.getIdOrder(),o,idOrderReservation);
					for(OrderDish d: o.getListOrderDish()) {
						updateDishOrder(d.getIdOrderDish(),d);
					}	
				}										
			}
			updateAccount(a.getIdAccount(),a,reservation.getIdReservation());
		}		
	}
	
	public void changeOrderReservationStatus(Long idOrderReservation, String status) {
		statusControl.changeOrderReservationStatus(status, idOrderReservation);
		//Reservation reservation = repoRes.findByIdReservation(repoOR.findByIdOrderReservation(idOrderReservation).getIdReservation());
		/*for(Account a: reservation.getListAccount()) {
			for(Orders o: a.getListOrder()) {
				statusControl.changeOrderStatus(status, o);
			}
		}*/	
	}
	
	public void insertOrderReservation(Long idReservation, String status) {
		OrderReservation or = new OrderReservation();
		or.setIdReservation(idReservation);
		or.setStatus(status);
		or.setDate(formatter.format(new Date().getTime()));
		idOrderReservation = repoOR.save(or).getIdOrderReservation();
		
		
	}
	
	public void updateAccount(Long idAccount, Account account, Long idReservation) {
		Account a = repoAccount.findByIdAccount(idAccount);
		double subtotal = repoOrder.getSubTotalByAccount(idAccount);
		
		Tax taxDto = repoTax.findByIdReservation(idReservation);
		Tip tipDto = repoTip.findDefaultTipByIdReservation(idReservation);
		
		double tax = subtotal*taxDto.getPercentage()/100;
		double tip = (subtotal+tax)*tipDto.getPercentage()/100;
		double total = subtotal + tax + tip;
		
		a.setTax_percentage(taxDto.getPercentage());
		a.setTip_percentage(tipDto.getPercentage());
		a.setTax(tax);
		a.setTip(tip);
		a.setTotal(total);
		
		
		a.setSubtotal(subtotal);
		if(a.getListOrder().size()>0)
			a.setCurrency(a.getListOrder().get(0).getCurrency());
		repoAccount.save(a);		
	}
	
	public void updateOrder(Long idOrder, Orders order, Long idOrderReservation) {
		Orders o = repoOrder.findByIdOrder(idOrder);
		o.setIdOrderReservation(idOrderReservation);
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