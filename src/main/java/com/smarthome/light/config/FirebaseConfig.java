package com.smarthome.light.config;

import com.alexaframework.springalexa.config.AlexaConfiguration;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Component
public class FirebaseConfig {

    @Autowired
    private AlexaConfiguration configuration;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void initializeFirebase() throws Exception {
        Resource resource = resourceLoader.getResource("classpath:/firebase_credentials.json");

        FileInputStream inputStream = new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl(configuration.getProperty("firebase.database.url"))
                .build();
        FirebaseApp.initializeApp(options);
    }

    @Bean("databaseReference")
    public DatabaseReference databaseReference() {
        return FirebaseDatabase
                .getInstance()
                .getReference("ledState");
    }
}
