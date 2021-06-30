package com.example.appsisc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class FormCadastro extends AppCompatActivity {
    // E usado para cadastra no banco de dados as informação//


    private EditText edit_nome, edit_Email, edit_senha, edit_Endereço, edit_telefone;
    private Button bt_cadastra;
    String[] mensagens = {"Preencha Todos os Campos por favor ", "Cadastro Realizado com Sucesso "};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edit_nome.getText().toString();
                String Email = edit_Email.getText().toString();
                String senha = edit_senha.getText().toString();
                String Endereço = edit_Endereço.getText().toString();
                String telefone = edit_telefone.getText().toString();

//linha de codigo onde indica que falta preencher todos os campos.

                if (nome.isEmpty() || Email.isEmpty() || senha.isEmpty() || Endereço.isEmpty() || telefone.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }else{

                    CasdastraUsuario();


                }
            }

            private void CasdastraUsuario() {


            }
        });

    }

    private void IniciarComponentes() {
        edit_nome = findViewById(R.id.nome_castro);
        edit_Email = findViewById(R.id.Email);
        edit_senha = findViewById(R.id.senha);
        edit_Endereço = findViewById(R.id.Endereço);
        edit_telefone = findViewById(R.id.telefone);

    }
    }
