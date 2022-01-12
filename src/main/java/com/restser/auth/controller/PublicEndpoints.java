package com.restser.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    	notification.sendNotification("dTB9NafVQAWHVKKUKzx5ou:APA91bHsrgI_nJ71u2_IqlDcsbkdVEfR8kQcIPuqtLZEECt2yIII5PDGdLCMqyj-NYelhw-CDrxR8bJgCc16dBZvrhRMyfXUS6lzW7yKfuHh2aN3FnJSvnu1FhGSR_Vc5Fnd49k10jYX", 
    			"title", "message");
    }
}
