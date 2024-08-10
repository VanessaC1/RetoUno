package com.example.retouno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private CheckBox checkBoxTerms;
    private Button buttonRegister;

    //Clase para los datos del usuario.
    public UserManager userManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        checkBoxTerms=findViewById(R.id.checkBoxTerms);
        buttonRegister=findViewById(R.id.buttonRegister);

        userManager = new UserManager(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Registro.this, "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(Registro.this,"Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Registro.this,"Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                } else if (!checkBoxTerms.isChecked()) {
                    Toast.makeText(Registro.this,"Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
                }else {
                    registrarUsuario(email, password);
                }

            }
        });
    }
    private boolean isValidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target)&& Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    private void registrarUsuario(String email, String password){
        userManager.registerUser(email,password);
        Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        finish();
    }
}