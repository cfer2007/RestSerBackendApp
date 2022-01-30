package com.restser.controllers;

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

import com.restser.dto.ContactDTO;
import com.restser.model.Contact;
import com.restser.repository.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactRepository repo;

	@GetMapping
	public List<Contact> getList(){
		return repo.findAll();
	}
	@GetMapping("/{id}")
	List<ContactDTO> getListById(@PathVariable("id") String id){
		return (List<ContactDTO>) repo.findByUser(id);		
	}
	@PostMapping
	public void setContact(@RequestBody Contact rest) {
		repo.save(rest);
	}
	/*@PostMapping("/list")
	public void setContactList(@RequestBody List<Contact> list) {
		repo.saveAll(list);
	}*/
	@PostMapping("/list")
	public void setContactList(@RequestBody List<Contact> list) {
		list.forEach(e -> {
				try {
					repo.insertContact(
					e.getDate(),
					e.getUser().getUid(),
					e.getFriend().getUid());
				}
				catch(Exception ex){System.out.println(ex.getMessage());}
			});		
	}
	
	@PutMapping
	public void updateContact(@RequestBody Contact rest) {
		repo.save(rest);
	}
	@DeleteMapping("/list")
	public void deleteContact(@RequestBody List<Contact> list) {
		list.forEach(e -> {
			try {
				repo.deleteContact(
				e.getUser().getUid(),
				e.getFriend().getUid());
			}
			catch(Exception ex){System.out.println(ex.getMessage());}
		});
	}
}
