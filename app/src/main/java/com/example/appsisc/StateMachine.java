package com.example.appsisc;

import com.google.firebase.auth.FirebaseUser;

public class StateMachine {
    private FirebaseUser loggedUser;

    private String endereçoUsuario;
    private String celularUsuario;

    public FirebaseUser getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(FirebaseUser loggedUser) {
        this.loggedUser = loggedUser;
        this.endereçoUsuario = "";
        this.celularUsuario = "";
    }

    public void clearLoggedUser()
    {
        this.loggedUser = null;
    }

}
