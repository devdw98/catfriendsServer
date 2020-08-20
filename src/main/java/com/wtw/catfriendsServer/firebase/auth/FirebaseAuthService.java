package com.wtw.catfriendsServer.firebase.auth;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseAuthService {

    //사용자 데이터 검색
    public Map<?,?> searchUserData(String uid) throws FirebaseAuthException {
        UserRecord userData = FirebaseAuth.getInstance().getUser(uid);
        Map<String, String> result = new HashMap<>();
        result.put("uid",userData.getUid());
        return result;
    }

    //사용자 만들기 - 보류
    //사용자 업데이트
    //사용자 삭제
    public Map<?,?> deleteUserData(String uid) throws FirebaseAuthException{
        Map<String, String> result = new HashMap<>();
        FirebaseAuth.getInstance().deleteUser(uid);
        result.put("success",uid);
        return result;
    }

}
