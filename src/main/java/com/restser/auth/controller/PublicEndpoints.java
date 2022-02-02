package com.restser.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.NotificationDTO;
import com.restser.service.NotificationService;



@RestController
@RequestMapping("public")
public class PublicEndpoints {

	private NotificationService notification=new NotificationService();
	
    @GetMapping("test")
    ResponseEntity<String> getPublic() {
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/notification")
    public void sendMessage() {
    	Map<String,String> map=new HashMap<String, String>();
    	map.put("action", "order_setted");
    	map.put("id", "3");
    	NotificationDTO notificationDto = new NotificationDTO();
    	notificationDto.setFcmToken("dEYUrNulRM2aCU9LdP7Q1D:APA91bGQDpyynuDXwnSs_zDEEmoIlcfOKIZYVQv5WSerOaUIwQasWffCnCBCv-aZCI8rTXGbZExkSOafyO64Dnd1ZJcvM-2hVeFN2Voc7vkYjqXxKHWwqMO_toC3JExAb-UsayjeOKcP");
    	notificationDto.setTitle("title");
    	notificationDto.setMessage("message");
    	notificationDto.setData(map);
    	
    	
    	notification.sendNotification(notificationDto);
    }
}
