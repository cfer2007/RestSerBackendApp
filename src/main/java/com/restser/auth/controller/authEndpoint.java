package com.restser.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.restser.auth.request.LoginRequest;
import com.restser.auth.request.SignUpRequest;
//import com.restser.auth.response.FirebaseSignInSignUpResponseBean;
//import com.restser.auth.service.EmployeeAuthenticationServiceImpl;
//import com.restser.auth.service.UserAuthenticationServiceImpl;
import com.restser.model.Employee;
import com.restser.model.User;
import com.restser.repository.EmployeeRepository;
import com.restser.repository.UserRepository;
@RestController
@RequestMapping("auth")
public class authEndpoint {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/signUpUser")
	public void SignUpUser(@RequestBody SignUpRequest user) {
		User u = new User();
		u.setEmail(user.getEmail());
		u.setFcmToken(user.getFcmToken());
		u.setUid(user.getUid());
		u.setUsername(user.getEmail());
		userRepo.save(u);
	}
	
	@PostMapping("/signInEmployeeWithEmailAndPassword")
	public Employee SingInEmployee(@RequestBody SignUpRequest e) {
		Employee employee = empRepo.findByUid(e.getUid());
		
		if(employee.getFcmToken() == null) {
			employee.setFcmToken(e.getFcmToken());
			empRepo.save(employee);
		}
		
		return employee;
	}
}
