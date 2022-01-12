package com.restser.auth.request;

import javax.validation.constraints.NotBlank;

public class SignUpRequest {
	
	private String uid;	
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String fcmToken;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}	
}
