package com.example.retouno;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {

    private Button buttonVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        //GUI
        Button buttonVolver = findViewById(R.id.button26);

        //Escuchador
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent del cambio de pantalla
                Intent irAPrincipal = new Intent(Estadisticas.this,Principal.class);
                startActivity(irAPrincipal);
            }
        });

        //Recepcion de informacion de las demas pantallas

        //Datos provenientes de la categoria vidrio

        //Recuperar los datos del color del vidrio
        SharedPreferences sharedPreferencesVidrio = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String spinnerSelection = sharedPreferencesVidrio.getString("spinner_selection", "Default Value");

        //Recuperar el decimal de lo registrado
        Intent intent_vidrio = getIntent();
        double decimalValue = intent_vidrio.getDoubleExtra("decimal_value", 0.0);

        //Datos provenientes de la categoria plastico
        //Recuperar los textos desde SharedPreferences
        SharedPreferences sharedPreferencesPlastico = getSharedPreferences("Plasticos", MODE_PRIVATE);
        String plastico1 = sharedPreferencesPlastico.getString("text1", "Default Value 1");
        String plastico2 = sharedPreferencesPlastico.getString("text2", "Default Value 2");
        String plastico3 = sharedPreferencesPlastico.getString("text3", "Default Value 3");

        //Mostrarlos en algun lado
        //TextView textView1 = findViewById(R.id.textView1);
        //TextView textView2 = findViewById(R.id.textView2);
        //textView1.setText(text1);
        //textView2.setText(text2);

        //Datos provenientes de la categoria e-waste
        // Recuperar datos de SharedPreferences
        SharedPreferences sharedPreferencesEwaste = getSharedPreferences("Electro", MODE_PRIVATE);
        String componenteSeleccionado = sharedPreferencesEwaste.getString("componente_seleccionado", "No Seleccionado");
        String tipoPilaSeleccionado = sharedPreferencesEwaste.getString("tipo_pila_seleccionado", "No Seleccionado");
        int integerValue = sharedPreferencesEwaste.getInt("integer_value", 0);

        // GUI
        //textViewComponente = findViewById(R.id.text_view_componente);
        //textViewTipoPila = findViewById(R.id.text_view_tipo_pila);
        //textViewInteger = findViewById(R.id.text_view_integer);
        //Mostrarlos en algun lado
        //textViewComponente.setText("Componente: " + componenteSeleccionado);
        //textViewTipoPila.setText("Tipo de Pila: " + tipoPilaSeleccionado);
        //textViewInteger.setText("Entero: " + integerValue);
        //Datos provenientes de la categoria metal
        // Recuperar los ArrayList enviados
        ArrayList<String> arrayList1 = getIntent().getStringArrayListExtra("arrayList1");
        ArrayList<String> arrayList2 = getIntent().getStringArrayListExtra("arrayList2");
        ArrayList<String> arrayList3 = getIntent().getStringArrayListExtra("arrayList3");
        ArrayList<String> arrayList4 = getIntent().getStringArrayListExtra("arrayList4");

        // Mostrar los primeros elementos de cada ArrayList
        //textView1.setText(arrayList1.get(0));
        //textView2.setText(arrayList2.get(0));
        //textView3.setText(arrayList3.get(0));
        //textView4.setText(arrayList4.get(0));

        //Datos provenientes de la categoria papel
        // Obtener el Intent que lanzó esta actividad
        Intent intent_papel = getIntent();

        // Recuperar el ArrayList enviado con los datos de recicla papel
        ArrayList<String> recicla_paper = intent_papel.getStringArrayListExtra("DATA_LIST");

        //Mostrar los datos al usuario
        if (recicla_paper != null && recicla_paper.size() >= 3) {
            // Mostrar los datos en los TextView
            //textView1.setText(recicla_paper.get(0));
            //textView2.setText(recicla_paper.get(1));
            //textView3.setText(Reecicla_paper.get(2));
        }
    }
}