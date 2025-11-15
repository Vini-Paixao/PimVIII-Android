package com.example.pimviiiandroidconsumer;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Vincula este Java ao layout XML
        setContentView(R.layout.activity_login);

        // 2. Encontra os componentes do XML pelo ID
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // 3. Configura o clique do botão
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chamamos a função de login simulado
                performLogin();
            }
        });
    }

    private void performLogin() {
        String email = editTextEmail.getText().toString();
        String senha = editTextPassword.getText().toString();

        // --- LÓGICA DE LOGIN SIMULADO ---
        // Aqui, não chamamos a API. Apenas verificamos se o usuário *digitou* algo.
        // Isso cumpre o requisito de demonstrar um fluxo de login.

        if (email.isEmpty() || senha.isEmpty()) {
            // Se algum campo estiver vazio
            Toast.makeText(this, "Por favor, preencha email e senha.", Toast.LENGTH_SHORT).show();
        } else {
            // Se ambos estiverem preenchidos (simulação de sucesso)
            Toast.makeText(this, "Login simulado com sucesso!", Toast.LENGTH_SHORT).show();

            // Navega da LoginActivity (this) para a MainActivity
            Intent intent = new Intent(LoginActivity.this, PlaylistActivity.class);
            startActivity(intent);

            // Fecha a LoginActivity (para o usuário não voltar apertando "Back")
            finish();
        }
    }
}