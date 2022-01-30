package com.restser.TransactionControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.restser.model.OrderDetail;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.model.ReservationDetail;
import com.restser.model.Tables;
import com.restser.repository.OrderDetailRepository;
import com.restser.repository.OrderRepository;
import com.restser.repository.ReservationDetailRepository;
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
	private ReservationDetailRepository repoReservationLog;
	@Autowired
	private OrderDetailRepository repoOrderLog;
	
	public void changeTableStatus(String status, Long idTable) {
		Tables table = tableRepo.findByIdTable(idTable);
		table.setStatus(status);
		tableRepo.save(table);
	}
	
	public void changeReservationStatus(String status, Long idReservation) {
		Reservation reservation = reservationRepo.findByIdReservation(idReservation); 
		reservation.setStatus(status);
		reservationRepo.save(reservation);
		setReservationLog(reservation);
	}
	
	public void changeOrderStatus(String status, List<Orders> list) {
		for(Orders o: list) {
			Orders order = orderRepo.findByIdOrder(o.getIdOrder());
			order.setStatus(status);
			orderRepo.save(order);
			setOrderLog(order);
		}
	}
	public void setReservationLog(Reservation res) {
		ReservationDetail det = new ReservationDetail();
		det.setDate(res.getStart());
		det.setStatus(res.getStatus());
		det.setIdReservation(res.getIdReservation());
		repoReservationLog.save(det);
	}
	public void setOrderLog(Orders order) {
		OrderDetail log = new OrderDetail();
		log.setDate(order.getDate());
		log.setStatus(order.getStatus());
		log.setIdOrder(order.getIdOrder());
		repoOrderLog.save(log);
	}
}