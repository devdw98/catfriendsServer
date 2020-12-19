package com.wtw.catfriendsServer.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

public class FirebaseMain {
    public static void main(String[] args) throws FirebaseAuthException {
        System.out.println("Hello Auth");
        FirebaseInitializer initializer = new FirebaseInitializer();
        initializer.initial();

        String uid = "dPIiZ1du79WZpYcD6MpetwVsQ4K2";
        UserRecord userRecord = FirebaseAuth.getInstance().getUser(uid);
        System.out.println("Success : "+userRecord.getEmail());
    }
}
