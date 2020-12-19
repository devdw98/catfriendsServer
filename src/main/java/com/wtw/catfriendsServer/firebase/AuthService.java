package com.wtw.catfriendsServer.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.ImportUserRecord;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {
    public UserRecord getUser(String uid) throws FirebaseAuthException;
}
