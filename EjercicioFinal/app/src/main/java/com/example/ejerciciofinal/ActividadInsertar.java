package com.example.ejerciciofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadInsertar extends AppCompatActivity {

    EditText etNombre, etDirector, etDuracion;
    Spinner spinnerSala;
    ArrayAdapter<String> adaptadorSpinner;
    RadioButton rb1, rb2, rb3, rb4;
    CalendarView calendarioFechas;
    Pelicula nuevaPelicula;
    Button guardar;
    String[] salasSpinner = {"Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad_insertar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNombre = findViewById(R.id.etTituloInsertar);
        etDirector = findViewById(R.id.etDirectorInsertar);
        etDuracion = findViewById(R.id.etDuracioInsertar);
        spinnerSala = findViewById(R.id.spinnerSalaInsertar);
        rb1 = findViewById(R.id.rb1Insertar);
        rb2 = findViewById(R.id.rb2Insertar);
        rb3 = findViewById(R.id.rb3Insertar);
        rb4 = findViewById(R.id.rb4Insertar);
        guardar = findViewById(R.id.btnGuardar);
        adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, salasSpinner);
        spinnerSala.setAdapter(adaptadorSpinner);
        calendarioFechas = findViewById(R.id.calendarioFechaInsertar);
        nuevaPelicula = new Pelicula(etNombre.getText(), etDirector.getText(),Integer.parseInt(etDuracion.getText()+""), calendarioFechas.getDate(), spinnerSala, , );
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}