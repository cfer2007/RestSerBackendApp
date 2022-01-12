package com.restser.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.restser.auth.response.FirebaseRefreshTokenToIdTokenResponseBean;
import com.restser.auth.response.FirebaseSignInSignUpResponseBean;
import com.restser.constants.ApiUrlConstants;
import com.restser.model.User;
import com.restser.repository.UserRepository;
import com.restser.utility.LoadConfProperties;
import com.restser.utility.StringUtility;
import com.restser.utility.CreateRequest;
import com.restser.utility.CreateResponse;

@Component
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    private String firebaseWebApiKey;
    
    private StringUtility stringUtility = null;
   
    LoadConfProperties properties = new LoadConfProperties();
    CreateRequest req = new CreateRequest();
    CreateResponse response = new CreateResponse();
    @Autowired
	UserRepository userRepo;

    public UserAuthenticationServiceImpl() {
        stringUtility = new StringUtility();
        firebaseWebApiKey = properties.getValue("fb.webkey");
    }
    
    @Override
    public FirebaseSignInSignUpResponseBean signInWithEmailAndPassword(String email, String password) {

        HttpEntity<String> request = req.createPostRequestBodyForEmailAndPassword(email, password);

        // This is the generated URI
        String url = stringUtility.findAndReplaceStringIntoString(ApiUrlConstants.FIREBASE_SIGNIN_EMAIL_AND_PASSWORD, ApiUrlConstants.FIREBASE_SIGNIN_EMAIL_AND_PASSWORD_TO_BE_CHANGED_PART, this.firebaseWebApiKey);

        ResponseEntity<FirebaseSignInSignUpResponseBean> responseEntity = (ResponseEntity<FirebaseSignInSignUpResponseBean>) response.doPostForEntity(url, request, FirebaseSignInSignUpResponseBean.class);
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }

    @Override
    public void deleteUserAccount(String idToken) {

        HttpEntity<String> request = req.createPostRequestBodyForIdToken(idToken);

        // This is the generated URI
        String url = stringUtility.findAndReplaceStringIntoString(ApiUrlConstants.FIREBASE_DELETE_USER_ACCOUNT,
                ApiUrlConstants.FIREBASE_DELETE_USER_ACCOUNT_TO_BE_CHANGED_PART,
                this.firebaseWebApiKey);

        response.doPostForEntity(url, request, null);
        

    }

    @Override
    public FirebaseSignInSignUpResponseBean signUpWithEmailAndPassword(String email, String password, String fcmToken) {

        HttpEntity<String> request = req.createPostRequestBodyForEmailAndPassword(email, password);
        String url = stringUtility.findAndReplaceStringIntoString(ApiUrlConstants.FIREBASE_SIGNUP_EMAIL_AND_PASSWORD,
                                                                    ApiUrlConstants.FIREBASE_SIGNUP_EMAIL_AND_PASSWORD_TO_BE_CHANGED_PART,
                                                                    this.firebaseWebApiKey);
        ResponseEntity<FirebaseSignInSignUpResponseBean> responseEntity = (ResponseEntity<FirebaseSignInSignUpResponseBean>) response.doPostForEntity(url, request, FirebaseSignInSignUpResponseBean.class);
        if(responseEntity.getStatusCodeValue() == 200) {
        	System.out.println(fcmToken);
        	User user = new User();        	
        	user.setEmail(responseEntity.getBody().getEmail());
        	user.setUsername(responseEntity.getBody().getEmail());
        	user.setUid(responseEntity.getBody().getLocalId());
        	user.setFcmToken(fcmToken);
        	userRepo.save(user);        	
        }
        return responseEntity.getBody();
    }

    @Override
    public FirebaseRefreshTokenToIdTokenResponseBean exchangeRefreshTokenToIdToken(String refreshToken) {

        HttpEntity<MultiValueMap<String, String>> request = req.createPostRequestBodyForRefreshTokenToIdToken(refreshToken);

        // This is the generated URI
        String url = stringUtility.findAndReplaceStringIntoString(ApiUrlConstants.FIREBASE_EXCHANGE_REFRESH_TOKEN_TO_ID_TOKEN,
                                                                    ApiUrlConstants.FIREBASE_EXCHANGE_REFRESH_TOKEN_TO_ID_TOKEN_TO_BE_CHANGED_PART,
                                                                    this.firebaseWebApiKey);

        ResponseEntity<FirebaseRefreshTokenToIdTokenResponseBean> responseEntity = (ResponseEntity<FirebaseRefreshTokenToIdTokenResponseBean>) response.doPostForEntity(url, request, FirebaseRefreshTokenToIdTokenResponseBean.class);

        return responseEntity.getBody();
    }

}
