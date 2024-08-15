package com.example.retouno;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import android.os.Bundle;

public class Vidrio extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4;
    private ArrayList<String> arrayList1, arrayList2, arrayList3, arrayList4;
    private Button buttonSave,buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidrio);

        // Obtener una referencia a la GUI
        EditText editText1 = findViewById(R.id.editTextText);
        EditText editText2 = findViewById(R.id.editTextText2);
        EditText editText3 = findViewById(R.id.editTextText3);
        EditText editText4 = findViewById(R.id.editTextText4);
        Button buttonSave = findViewById(R.id.button9);
        Button buttonBack = findViewById(R.id.button10);

        // Inicializar los ArrayList
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        arrayList4 = new ArrayList<>();

        //Configurar el boton de enviar datos a estadisticas
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capturar los textos ingresados
                arrayList1.add(editText1.getText().toString());
                arrayList2.add(editText2.getText().toString());
                arrayList3.add(editText3.getText().toString());
                arrayList4.add(editText4.getText().toString());

                // Enviar los ArrayList a la siguiente actividad
                Intent irACategorias = new Intent(Vidrio.this, Categorias.class);
                irACategorias.putStringArrayListExtra("arrayList1", arrayList1);
                irACategorias.putStringArrayListExtra("arrayList2", arrayList2);
                irACategorias.putStringArrayListExtra("arrayList3", arrayList3);
                irACategorias.putStringArrayListExtra("arrayList4", arrayList4);
                startActivity(irACategorias);
            }
        });
        //Configurar el boton de volver atras
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}