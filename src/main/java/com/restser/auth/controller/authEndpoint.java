package com.restser.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.auth.request.LoginRequest;
import com.restser.auth.request.SignUpRequest;
import com.restser.auth.response.FirebaseSignInSignUpResponseBean;
import com.restser.auth.service.UserAuthenticationServiceImpl;
import com.restser.model.User;
import com.restser.repository.UserRepository;
@RestController
@RequestMapping("auth")
public class authEndpoint {
	
	@Autowired
	private UserAuthenticationServiceImpl userAuthenticationServiceImpl;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/signInWithEmailAndPassword")
    public FirebaseSignInSignUpResponseBean signInWithEmailAndPassword(@RequestBody LoginRequest user) {
		FirebaseSignInSignUpResponseBean firebaseSignInSignUpResponseBean = userAuthenticationServiceImpl.signInWithEmailAndPassword(user.getEmail(),user.getPassword());
        return firebaseSignInSignUpResponseBean;

    }
	@PostMapping("/signUpWithEmailAndPassword")
	public FirebaseSignInSignUpResponseBean signUpWithEmailAndPassword(@RequestBody SignUpRequest user) {
        FirebaseSignInSignUpResponseBean firebaseSignInSignUpResponseBean = userAuthenticationServiceImpl.signUpWithEmailAndPassword(user.getEmail(),user.getPassword(),user.getFcmToken());
        return firebaseSignInSignUpResponseBean;

    }
	@PostMapping("/signUpUser")
	public void SignUpWithGoogle(@RequestBody SignUpRequest user) {
		User u = new User();
		u.setEmail(user.getEmail());
		u.setFcmToken(user.getFcmToken());
		u.setUid(user.getUid());
		u.setUsername(user.getEmail());
		userRepo.save(u);
	}
}
