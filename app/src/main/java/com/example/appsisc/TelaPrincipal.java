package com.example.appsisc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    private TextView nome_usuario;
    private AppSisc applicationInstance;
    private TextView email_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        getSupportActionBar().hide();

        this.applicationInstance = (AppSisc)this.getApplication();
        this.carregarComponentes();
        this.atualizarCampos();
    }

    protected void carregarComponentes() {
        this.nome_usuario = findViewById(R.id.nome_usuario);
        this.email_usuario = findViewById(R.id.email_usuario);
    }

    protected void atualizarCampos() {
        this.nome_usuario.setText(this.applicationInstance.state.getLoggedUser().getDisplayName());
        this.email_usuario.setText(this.applicationInstance.state.getLoggedUser().getEmail());
    }
}