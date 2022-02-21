package com.restser.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.ReservationActiveDTO;
import com.restser.dto.ReservationDTO;
import com.restser.model.Account;
import com.restser.model.Orders;
import com.restser.model.Reservation;
import com.restser.repository.AccountRepository;
import com.restser.repository.OrderRepository;
import com.restser.repository.ReservationRepository;
import com.restser.transaction.ConfirmReservation;

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
	
	@GetMapping
	public List<Reservation> getList(){
		return repo.findAll();
	}	
	@GetMapping("/{id}")
	public Reservation getReservation(@PathVariable("id") Long id){
		return repo.findByIdReservation(id);		
	}
	@GetMapping("/active/{uid}")
	public Reservation getActiveReservation(@PathVariable("uid") String uid){
		return repo.getActiveReservation(uid);		
	}
	@GetMapping("/list/{uid}")
	public List<ReservationDTO> getFinishReservationList(@PathVariable("uid") String uid){
		return repo.getFinishReservationList(uid);
	}
	
	/*@GetMapping("/listReservationActive/{uid}")
	public List<ReservationActiveDTO> getReservationActiveList(@PathVariable("uid") String uid){		
		List<ReservationActiveDTO> listOrdersActive = new ArrayList<ReservationActiveDTO>();		
		List<Long> listReservation = repo.getReservationsActive(uid);		
		for(Long id: listReservation) {
			List<Account> list = new ArrayList<Account>();			
			List<Account> listAccount = aRepo.getAccountListByIdReservation(id);			
			for(Account a: listAccount) {
				List<Orders> listOrder = oRepo.getOrdersActiveByAccount(a.getIdAccount());
				if(listOrder.size()>0) {
					a.setListOrder(listOrder);
					list.add(a);
				}				
			}
			if(list.size()>0) {
				ReservationActiveDTO temp = new ReservationActiveDTO();
				temp.setAccountList(list);
				temp.setIdReservation(id);
				listOrdersActive.add(temp);
			}
		}		
		return listOrdersActive;
	}*/
	@GetMapping("/reservation_active/{uid}")
	public ReservationActiveDTO getReservationActive(@PathVariable("uid") String uid){
		Reservation res = repo.getActiveReservation(uid);	
		
		ReservationActiveDTO resnull = new ReservationActiveDTO();
		List<Account> la = new ArrayList<Account>();
		resnull.setIdReservation(0L);
		resnull.setAccountList(la);
		
		if(res == null) {
			return resnull;
		}
			
		List<Account> list = new ArrayList<Account>();			
		List<Account> listAccount = aRepo.getAccountListByIdReservation(res.getIdReservation());			
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
			reservation.setIdReservation(res.getIdReservation());
			return reservation;	
		}
		else return resnull;
				
		
			
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
		
	@DeleteMapping(value="/{id}")
	public void deleteReservation(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
	
	
}
