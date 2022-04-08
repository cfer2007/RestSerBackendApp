package com.restser.controllers;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.EmptyJsonResponse;
import com.restser.dto.ReservationActiveDTO;
import com.restser.dto.ReservationDTO;
import com.restser.model.Account;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderRepository;
import com.restser.repository.ReservationRepository;
import com.restser.transaction.ConfirmReservation;
import com.restser.transaction.FinishReservation;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository repo;
	@Autowired
	private AccountRepository aRepo;
	@Autowired
	private OrderRepository oRepo;
	@Autowired
	private ConfirmReservation reservationControl;
	@Autowired
	private FinishReservation finishReservation;
	
	@GetMapping("/{id}")
	public Reservation getReservation(@PathVariable("id") Long id){
		return repo.findByIdReservation(id);		
	}	
	
	@GetMapping("/reservation_active/{uid}")
	public Reservation getActiveReservation(@PathVariable("uid") String uid){
		return repo.getActiveReservation(uid);		
	}
	@GetMapping("/list/{uid}")
	public List<ReservationDTO> getFinishReservationList(@PathVariable("uid") String uid){
		return repo.getFinishReservationList(uid);
	}
	
	@GetMapping("/reservation_orders_active/{uid}")
	public ResponseEntity<Object> getReservationActive(@PathVariable("uid") String uid){
		try {
			Reservation res = repo.getActiveReservation(uid);		
			List<Account> list = new ArrayList<Account>();			
			List<Account> listAccount = aRepo.findAccountListByIdReservation(res.getIdReservation());			
			for(Account a: listAccount) {
				List<Orders> listOrder = oRepo.getOrdersActiveByAccount(a.getIdAccount());
				if(listOrder.size()>0) {
					a.setListOrder(listOrder);
					list.add(a);
				}				
			}
			ReservationActiveDTO reservation = new ReservationActiveDTO();
			if(list.size()>0) {	
				reservation.setAccountList(list);
				//reservation.setIdReservation(res.getIdReservation());
				reservation.setReservation(res);
				return new ResponseEntity<Object>(reservation, null, HttpStatus.SC_OK);
			}
			else {
				return new ResponseEntity<Object>(new EmptyJsonResponse(), null, HttpStatus.SC_NOT_FOUND);
			} 
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Object>(new EmptyJsonResponse(), null, HttpStatus.SC_NOT_FOUND);
		}
	}
	
	@GetMapping("/branch/{idBranch}")
	public List<Reservation> getCollectingAccountsReservationByIdBranch(@PathVariable("idBranch") Long idBranch){
		return repo.getCollectingAccountsReservationByIdBranch(idBranch);		
	}
	
	@PostMapping
	public Long setReservation(@RequestBody Reservation rest) {
		Long id = repo.save(rest).getIdReservation();
		rest.setIdReservation(id);	
		return id;
	}
	@PutMapping
	public void confirmReservation(@RequestBody Reservation rest) {
		reservationControl.confirmReservation(rest);
	}
	
	@PutMapping("/finish/{idReservation}")
	public void finishReservation(@PathVariable("idReservation") Long idReservation) {
		finishReservation.finish(idReservation);
	}
}
