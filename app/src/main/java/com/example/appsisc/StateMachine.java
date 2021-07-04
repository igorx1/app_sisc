package com.example.appsisc;

import com.google.firebase.auth.FirebaseUser;

public class StateMachine {
    private FirebaseUser loggedUser;

    public FirebaseUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(FirebaseUser loggedUser) {
        this.loggedUser = loggedUser;
    }

}
