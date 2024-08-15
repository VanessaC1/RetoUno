package com.example.retouno;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.widget.EditText;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class Glass extends AppCompatActivity {

    private Spinner colorSpinner;
    private EditText editTextDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass);

        // Obtener una referencia al Spinner
        Spinner colorSpinner = (Spinner) findViewById(R.id.spinner);

        //Obtener la referencia del peso del vidrio
        EditText editTextDecimal = findViewById(R.id.editTextNumberDecimal);
        String decimalValue = editTextDecimal.getText().toString();

        //Lanzar el intent para pasar el dato a la otra pantalla
        Intent intent = new Intent(Glass.this, Estadisticas.class);
        intent.putExtra("decimal_value", decimalValue);
        startActivity(intent);

        // Crear un ArrayAdapter usando un array de colores
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplicar el adaptador al Spinner
        colorSpinner.setAdapter(adapter);

        // Configurar el listener para la selección del Spinner
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el color seleccionado
                String selectedColor = (String) parent.getItemAtPosition(position);

                // Mostrar un mensaje con el color seleccionado
                Toast.makeText(Glass.this, "Seleccionaste: " + selectedColor, Toast.LENGTH_SHORT).show();

                // Guardar en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("spinner_selection", selectedColor);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Manejar el caso en que no se seleccione nada
                Toast.makeText(Glass.this, "No seleccionaste nada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}