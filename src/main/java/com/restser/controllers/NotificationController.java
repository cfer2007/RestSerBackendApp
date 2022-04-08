package com.restser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restser.dto.NotificationDTO;
import com.restser.repository.UserRepository;
import com.restser.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/order_setted")
    public void sendMessage(@RequestBody NotificationDTO notification) {
		try {
			notification.setFcmToken(userRepo.findByUid(notification.getUid()).getFcmToken());
			notificationService.sendNotification(notification);
		}
		catch(Exception error) {
			System.out.println(error);
		}
    }
	
}
