package com.restser.auth.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.restser.auth.models.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @Autowired
    SecurityProperties secProps;

    @Primary
    @Bean
    public void firebaseInit() {
        InputStream inputStream1 = null;
        InputStream inputStream2 = null;
        
        try {
            inputStream1 = new ClassPathResource("firebase_config.json").getInputStream();
            inputStream2 = new ClassPathResource("restserempapp-firebase.json").getInputStream();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {

            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(inputStream1)).build();
            FirebaseOptions options2 = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(inputStream2)).build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options,"restserapp");
                FirebaseApp.initializeApp(options2,"restserempapp");
            }
            System.out.println("Firebase Initialize");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
