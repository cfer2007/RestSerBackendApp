package com.restser.transaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.restser.model.OrderReservation;
import com.restser.model.OrderReservationDetail;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.model.Tables;
import com.restser.repository.OrderDetailRepository;
import com.restser.repository.OrderRepository;
import com.restser.repository.OrderReservationRepository;
import com.restser.repository.ReservationRepository;
import com.restser.repository.TableRepository;


@Controller
public class StatusControl {
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private TableRepository tableRepo;
	@Autowired
	private OrderRepository orderRepo;	
	@Autowired
	private OrderReservationRepository repoOR;
	@Autowired
	private OrderDetailRepository repoOrderLog;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Calendar calendar = Calendar.getInstance();
	
	public void changeTableStatus(String status, Long idTable) {
		Tables table = tableRepo.findByIdTable(idTable);
		table.setStatus(status);
		tableRepo.save(table);
	}
	
	public void changeReservationStatus(String status, Long idReservation) {
		System.out.println("changeReservationStatus");
		
		Reservation reservation = reservationRepo.findByIdReservation(idReservation); 
		reservation.setStatus(status);
		reservationRepo.save(reservation);
	}
	
	public void changeOrderReservationStatus(String status, Long idOrderReservation ) {
		System.out.println("changeOrderReservationStatus");
		System.out.println("Status: "+status);
		OrderReservation orderReservation = repoOR.findByIdOrderReservation(idOrderReservation);
		orderReservation.setStatus(status);
		repoOR.save(orderReservation);
		setOrderReservationLog(idOrderReservation);
	}
	
	public void changeOrderStatus(String status, List<Orders> list) {
		System.out.println("changeOrderStatus");
		for(Orders o: list) {
			if(o.getStatus() == "started") {
				Orders order = orderRepo.findByIdOrder(o.getIdOrder());
				order.setStatus(status);
				orderRepo.save(order);
			}			
		}
	}
	public void changeOrderStatus(String status, Orders o) {
		Orders order = orderRepo.findByIdOrder(o.getIdOrder());
		order.setStatus(status);
		orderRepo.save(order);						
		
	}
	public void setOrderReservationLog(Long idOrderReservation) {
		System.out.println("setOrderReservationLog");
		OrderReservation or = repoOR.findByIdOrderReservation(idOrderReservation);
		OrderReservationDetail log = new OrderReservationDetail();
		log.setDate(formatter.format(calendar.getTime()));
		log.setStatus(or.getStatus());
		log.setOrderReservation(or);
		repoOrderLog.save(log);
	}
}
