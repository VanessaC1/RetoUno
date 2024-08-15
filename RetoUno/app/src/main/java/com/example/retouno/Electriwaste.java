package com.example.retouno;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

public class Electriwaste extends AppCompatActivity {

    private Spinner spinnerComponentes, spinnerTipoPila;
    private Button buttonSave,buttonBack;
    private EditText editTextPCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electriwaste);

        Spinner spinnerComponents = findViewById(R.id.spinner3);
        Spinner spinnerTipoPila = findViewById(R.id.spinner4);
        EditText editTextPCB = findViewById(R.id.editTextNumber4);
        Button buttonSave = findViewById(R.id.button15);
        Button buttonBack = findViewById(R.id.button18);

        // Configurar el listener para el botón
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSpinnerSelections();
            }
            private void saveSpinnerSelections() {
                // Obtener los valores seleccionados
                String componenteSeleccionado = spinnerComponentes.getSelectedItem().toString();
                String tipoPilaSeleccionado = spinnerTipoPila.getSelectedItem().toString();

                // Obtener el valor entero del EditText
                String integerValue = editTextPCB.getText().toString();

                //Variables auxiliares
                int integer = 0;
                integer = Integer.parseInt(integerValue);

                // Guardar en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("Electro", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("componente_seleccionado", componenteSeleccionado);
                editor.putString("tipo_pila_seleccionado", tipoPilaSeleccionado);
                editor.putInt("integer_value", integer);
                editor.apply(); // o editor.commit();

                // Iniciar la segunda actividad
                Intent intent = new Intent(Electriwaste.this, Estadisticas.class);
                startActivity(intent);
            }
        });

        //Configurar el listener del boton Atras
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electriwaste.this, Categorias.class);
                startActivity(intent);
            }
        });
    }
}