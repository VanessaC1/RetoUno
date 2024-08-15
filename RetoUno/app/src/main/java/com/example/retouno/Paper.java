package com.example.retouno;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class Paper extends AppCompatActivity {

    //Declaracion de variables
    private EditText editTextVariable1, editTextVariable2, editTextVariable3;
    private Button buttonSubmit,buttonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);

        //Relacionamiento con la interfaz grafica de usuario
        //Captura de datos
        EditText editTextVariable1 = findViewById(R.id.editTextNumber);
        EditText editTextVariable2 = findViewById(R.id.editTextNumber2);
        EditText editTextVariable3 = findViewById(R.id.editTextNumber3);
        //Botones
        Button buttonSubmit = findViewById(R.id.button11);
        Button buttonVolver = findViewById(R.id.button12);

        //Escuchadores de los botones
        //Boton enviar informacion
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear el ArrayList y añadir los datos
                ArrayList<String> data = new ArrayList<>();
                data.add(editTextVariable1.getText().toString());
                data.add(editTextVariable2.getText().toString());
                data.add(editTextVariable3.getText().toString());

                // Crear un Intent para enviar los datos
                Intent intent = new Intent(Paper.this, MainActivity.class);
                intent.putStringArrayListExtra("DATA_LIST", data);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Informacion guardada",Toast.LENGTH_SHORT).show();
            }
        });
        //Boton volver atras
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambio de pantalla
                Intent irACategorias = new Intent(Paper.this,Categorias.class);
                startActivity(irACategorias);
            }
        });
    }
}