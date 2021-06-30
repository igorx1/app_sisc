package com.example.appsisc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormiLogin extends AppCompatActivity {
// igor 

    private TextView text_tela_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formi_login);


        getSupportActionBar().hide();
        iniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( FormiLogin.this, FormCadastro.class);
                startActivity(intent);



            }
        });

          }

          private void iniciarComponentes(){

        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);


    }
}