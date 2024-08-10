package com.example.retouno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText ediTextEmail, ediTextPassword;
    private Button btnIngresar,btnRegister;

    private UserManager userManager;

    private View view_container_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIngresar = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        ediTextEmail = findViewById(R.id.TextEmailAddress);
        ediTextPassword = findViewById(R.id.TextPassword);

        userManager = new UserManager(this);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ediTextEmail.getText().toString();
                String password = ediTextPassword.getText().toString();
                if(userManager.LoginUser(email,password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Email o Password incorrecto", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Registro.class);
                startActivity(intent);
            }
        });

    }

}

