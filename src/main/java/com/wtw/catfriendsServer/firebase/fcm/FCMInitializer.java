package com.wtw.catfriendsServer.firebase.fcm;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FCMInitializer {

    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;
    @Value("${app.firebase-database-url}")
    private String firebaseDatabaseUrl;
    Logger log = LoggerFactory.getLogger(FCMInitializer.class);

    @PostConstruct
    public void initialize(){
        try{
            FileInputStream serviceAccount = new FileInputStream(firebaseConfigPath);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl(firebaseDatabaseUrl)
                    .build();
            if (FirebaseApp.getApps().isEmpty()){
                FirebaseApp.initializeApp(options);
                log.info("Firebase application has been initialized.");
            }
        }catch (IOException e){
            log.error(e.getMessage());
        }
    }

}
