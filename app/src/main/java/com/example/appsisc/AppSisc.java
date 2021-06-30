package com.example.appsisc;

import android.app.Application;

public class AppSisc extends Application {
    StateMachine state;

    @Override
    public void onCreate() {
        super.onCreate();
        this.state = new StateMachine();
    }
}
