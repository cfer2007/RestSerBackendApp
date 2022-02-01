package com.restser.utility;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.restser.dto.NotificationDTO;

public class CreateRequest {
	
	/*public HttpEntity<String> createPostRequestSendNotification(String fcmServerkey, String fcmToken, String title, String message) {

    	JSONObject notification = new JSONObject();
        notification.put("body", message);
        notification.put("title", title);
        
        JSONObject data = new JSONObject();
        data.put("id_reservation","3");
    	
        JSONObject requestBodyJsonObject = new JSONObject();
        requestBodyJsonObject.put("to", fcmToken);
        requestBodyJsonObject.put("notification", notification);
        requestBodyJsonObject.put("data", data);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", fcmServerkey);

        return new HttpEntity<String>(requestBodyJsonObject.toString(), httpHeaders);
    }*/
	
	public HttpEntity<String> createPostRequestSendNotification(NotificationDTO notificationDto,String fcmServerkey) {

    	JSONObject notification = new JSONObject();
        notification.put("body", notificationDto.getMessage());
        notification.put("title", notificationDto.getTitle());
        
        JSONObject data = new JSONObject();
        notificationDto.getData().forEach((key, value) -> {
        	data.put(key,value);
        });
        
    	
        JSONObject requestBodyJsonObject = new JSONObject();
        requestBodyJsonObject.put("to", notificationDto.getFcmToken());
        requestBodyJsonObject.put("notification", notification);
        requestBodyJsonObject.put("data", data);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", fcmServerkey);

        return new HttpEntity<String>(requestBodyJsonObject.toString(), httpHeaders);
    }
	
	public HttpEntity<String> createPostRequestBodyForEmailAndPassword(String email, String password) {

        JSONObject requestBodyJsonObject = new JSONObject();
        requestBodyJsonObject.put("email", email);
        requestBodyJsonObject.put("password", password);
        requestBodyJsonObject.put("returnSecureToken", "true");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestBody = new HttpEntity<String>(requestBodyJsonObject.toString(), httpHeaders);

        return requestBody;

    }

    public HttpEntity<String> createPostRequestBodyForIdToken(String idToken) {

        JSONObject requestBodyJsonObject = new JSONObject();
        requestBodyJsonObject.put("idToken", idToken);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestBody = new HttpEntity<String>(requestBodyJsonObject.toString(), httpHeaders);

        return requestBody;

    }

    public HttpEntity<MultiValueMap<String, String>> createPostRequestBodyForRefreshTokenToIdToken(String refreshToken) {

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "refresh_token");
        map.add("refresh_token", refreshToken);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestBody = new HttpEntity<MultiValueMap<String, String>>(map, httpHeaders);

        return requestBody;

    }
}
;