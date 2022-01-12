package com.restser.auth.models;

import com.google.firebase.auth.FirebaseToken;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credentials {

	public enum CredentialType {
		ID_TOKEN, SESSION
	}

	private CredentialType type;
	private FirebaseToken decodedToken;
	private String idToken;
	private String session;
	public Credentials(CredentialType type2, FirebaseToken decodedToken2, String token, String session2) {
		// TODO Auto-generated constructor stub
	}
	public CredentialType getType() {
		return type;
	}
	public void setType(CredentialType type) {
		this.type = type;
	}
	public FirebaseToken getDecodedToken() {
		return decodedToken;
	}
	public void setDecodedToken(FirebaseToken decodedToken) {
		this.decodedToken = decodedToken;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	
}
