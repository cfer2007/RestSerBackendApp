package com.restser.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restser.constants.ApiUrlConstants;
import com.restser.dto.NotificationDTO;
import com.restser.utility.CreateRequest;
import com.restser.utility.CreateResponse;
import com.restser.utility.LoadConfProperties;

@Service
public class NotificationService {
	
	private String fcmServerKey;
	LoadConfProperties properties = new LoadConfProperties();
    CreateRequest req = new CreateRequest();
    CreateResponse response = new CreateResponse();
	
	public NotificationService() {
		fcmServerKey = properties.getValue("fb.cmserverkey");
	}
	
	public ResponseEntity<String> sendNotification(NotificationDTO notification) {
		HttpEntity<String> request = req.createPostRequestSendNotification(notification,fcmServerKey);
    	ResponseEntity<String> responseEntity = (ResponseEntity<String>) response.doPostForEntity(ApiUrlConstants.FCM_SEND_MESSAGE, request, String.class);
    	return responseEntity;
    }
}
