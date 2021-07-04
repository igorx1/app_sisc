package com.example.appsisc;

import android.app.Application;

import com.google.firebase.firestore.FirebaseFirestore;

public class AppSisc extends Application {
    StateMachine state;
    FirebaseFirestore db;

    @Override
    public void onCreate() {
        super.onCreate();
        this.db = FirebaseFirestore.getInstance();
        this.state = new StateMachine();
    }
}
