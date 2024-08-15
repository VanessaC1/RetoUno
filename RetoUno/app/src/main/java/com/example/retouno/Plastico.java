package com.example.retouno;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

public class Plastico extends AppCompatActivity {

    private TextView plastic_one, plastic_two, plastic_three;
    private Button button_guardar, button_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastico);

        //Obtener la referencia a la GUI
        TextView plastic_one = findViewById(R.id.textView3);
        TextView plastic_two = findViewById(R.id.textView4);
        TextView plastic_three = findViewById(R.id.textView5);
        Button button_guardar = findViewById(R.id.button13);
        Button button_volver = findViewById(R.id.button14);

        //Escuchador del boton guardar
        button_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Capturar los datos de los TextView
                String text1 = plastic_one.getText().toString();
                String text2 = plastic_two.getText().toString();
                String text3 = plastic_three.getText().toString();

                //Guardar los datos en Shared Preferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("text1", text1);
                editor.putString("text2", text2);
                editor.putString("text3", text3);
                editor.apply();

                //Disparo los datos a traves de un intent
                Intent intent_plastico = new Intent(Plastico.this, Estadisticas.class);
                startActivity(intent_plastico);
            }
        });
        //Escuchador del boton volver
        button_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Listener del boton Volver
                Intent irACategorias = new Intent(Plastico.this, Categorias.class);
                startActivity(irACategorias);
            }
        });

    }
}