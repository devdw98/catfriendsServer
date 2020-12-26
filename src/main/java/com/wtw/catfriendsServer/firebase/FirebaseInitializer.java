package com.wtw.catfriendsServer.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
@NoArgsConstructor
public class FirebaseInitializer {
    private static final Logger log = LoggerFactory.getLogger(FirebaseInitializer.class);
    private static final String FIREBASE_CONFIG_PATH = "wtw-firebase-meow.json";// "wtw-test.json";

//    @Value("${spring.datasource.username}")
//    private String firebaseConfigPath;

    @PostConstruct
    public void initial(){
        try{
            System.out.println(FIREBASE_CONFIG_PATH);
            ClassPathResource serviceAccount = new ClassPathResource(FIREBASE_CONFIG_PATH);//(FIREBASE_CONFIG_PATH);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream())) //비밀키 가져와서 증명
                    .build();
            if(FirebaseApp.getApps().isEmpty()){
                FirebaseApp.initializeApp(options);
                log.info("Firebase application has been initialized.");
            }
        }catch (IOException e){
            log.error(e.getMessage());
        }
    }
}
