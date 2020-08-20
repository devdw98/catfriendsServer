package com.wtw.catfriendsServer.firebase.firestore;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class FirestoreService {
    private Logger log = LoggerFactory.getLogger(FirestoreService.class);
    private Firestore db = FirestoreClient.getFirestore();

    //add data
    public void addDocument(Map<String, ?> data) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = db.collection((String) data.get("collection"))
                .document((String) data.get("document")).set(data.get("ref")); //객체 단위로 저장
        log.info("Update time: "+ future.get().getUpdateTime());
    }

    public void getCollection(String collection){
        ApiFuture<QuerySnapshot> query = db.collection(collection).get();
    }

    public void getDocument(String collection, String document){
        ApiFuture<DocumentSnapshot> query = db.collection(collection).document(document).get();
    }

    public void updateDocument(String collection, String document, Map<String, Object> data){
        DocumentReference ref = db.collection(collection).document(document);
        ApiFuture<WriteResult> future = ref.update(data);
    }

    public void deleteDocument(String collection, String document) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> ref = db.collection(collection).document(document).delete();
        log.info("Delete Document. time: "+ref.get().getUpdateTime());
    }

}

