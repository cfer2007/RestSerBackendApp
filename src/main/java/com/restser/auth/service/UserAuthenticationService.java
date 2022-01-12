package com.restser.auth.service;

import com.restser.auth.response.FirebaseRefreshTokenToIdTokenResponseBean;
import com.restser.auth.response.FirebaseSignInSignUpResponseBean;

public interface UserAuthenticationService {

    public FirebaseSignInSignUpResponseBean signUpWithEmailAndPassword(String email, String password, String fcmToken);

    public FirebaseSignInSignUpResponseBean signInWithEmailAndPassword(String email, String password);

    public void deleteUserAccount(String idToken);

    public FirebaseRefreshTokenToIdTokenResponseBean exchangeRefreshTokenToIdToken(String refreshToken);

}
