package com.example.appsisc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class TelaPrincipal extends AppCompatActivity {

    private TextView nome_usuario;
    private AppSisc applicationInstance;
    private TextView email_usuario;
    private View bt_deslogar;
    private TextView endereço_usuario;
    private TextView celular_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.applicationInstance = (AppSisc)this.getApplication();
        setContentView(R.layout.activity_tela_principal);

        this.carregarComponentes();
        bt_deslogar.setOnClickListener((view) -> {
            this.applicationInstance.state.clearLoggedUser();
            Intent intent = new Intent( TelaPrincipal.this, FormiLogin.class);
            startActivity(intent);
        });
        endereço_usuario.setOnClickListener(view -> {
//            view.setVisibility(View.INVISIBLE);
            LinearLayout parent = (LinearLayout) view.getParent();

            EditText newInput = new EditText(this);
            newInput.setText("Teste de texto");
            newInput.setLayoutParams(view.getLayoutParams());

            newInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        String id_usuario = applicationInstance.state.getLoggedUser().getUid();

                        // Objeto para representar os dados de usuário
                        Map<String, Object> usuario = new HashMap<>();
                        usuario.put("endereço", v.getText());

                        applicationInstance.db.collection("usuarios").document(id_usuario).set(usuario);
                        return true;
                    }
                    return false;
                }
            });

            parent.removeViewAt(parent.indexOfChild(view));
            parent.addView(newInput);
        });

        this.atualizarCampos();

        getSupportActionBar().hide();
    }

    protected void carregarComponentes() {
        this.nome_usuario = findViewById(R.id.nome_usuario);
        this.email_usuario = findViewById(R.id.email_usuario);
        this.bt_deslogar = findViewById(R.id.bt_deslogar);
        this.endereço_usuario = findViewById(R.id.endereço_usuario);
        this.celular_usuario = findViewById(R.id.celular_usuario);
        //Log.d("DEBUG", this.bt_deslogar.toString());
    }

    protected void atualizarCampos() {
        this.nome_usuario.setText(this.applicationInstance.state.getLoggedUser().getDisplayName());
        this.email_usuario.setText(this.applicationInstance.state.getLoggedUser().getEmail());
    }
}