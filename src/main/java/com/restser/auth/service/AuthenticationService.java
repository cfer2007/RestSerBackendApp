package com.restser.auth.service;

import org.springframework.http.ResponseEntity;

import com.restser.auth.response.FirebaseRefreshTokenToIdTokenResponseBean;
import com.restser.auth.response.FirebaseSignInSignUpResponseBean;

public interface AuthenticationService {

    public FirebaseSignInSignUpResponseBean signUpWithEmailAndPassword(String email, String password, String fcmToken);

    public ResponseEntity<FirebaseSignInSignUpResponseBean> signInWithEmailAndPassword(String email, String password);

    public void deleteUserAccount(String idToken);

    public FirebaseRefreshTokenToIdTokenResponseBean exchangeRefreshTokenToIdToken(String refreshToken);

}
