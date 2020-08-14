package com.wtw.catfriendsServer.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wtw.catfriendsServer.etc.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@PropertySource(value = "classpath:firebase.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "firebase")
public class FirebaseConfig {
    //initialize firebase admin sdk
    public FirebaseConfig() throws IOException {

    }

    //firebase admin sdk
    FileInputStream serviceAccount = new FileInputStream("firebase.GOOGLE_APPLICATION_CREDENTIALS");
    //use firebase oauth 2.0 token
//    FileInputStream refreshToken = new FileInputStream("firebase.OAUTH2.0_REFRESH_TOKEN");

    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//            .setCredentials(GoogleCredentials.fromStream(refreshToken))
            .setDatabaseUrl("https://catfriends-91f48.firebaseio.com")
            .build();

//    FirebaseApp app = FirebaseApp.initializeApp(options);

    public void initial(){
        FirebaseApp app = FirebaseApp.initializeApp(options);
    }



    //database
//    FirebaseDatabase database = FirebaseDatabase.getInstance().getReference()
//            .getDatabase();




    //OAuth 2.0
//    FileInputStream refreshToken = new FileInputStream("path/to/refreshToken.json");
//
//    FirebaseOptions options = new FirebaseOptions.Builder()
//            .setCredentials(GoogleCredentials.fromStream(refreshToken))
//            .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
//            .build();
//

}
