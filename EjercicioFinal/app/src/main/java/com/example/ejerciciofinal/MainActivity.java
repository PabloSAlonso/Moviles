package com.example.ejerciciofinal;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Toolbar tb;
    Button boton;
    RecyclerView.LayoutManager miLayoutManager;
    MiAdaptador miAdaptador;
    ArrayList<Pelicula>peliculas;
    ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        peliculas = Datos.rellenaPeliculas();
        miAdaptador = new MiAdaptador(peliculas);
        boton = findViewById(R.id.btnActionBar);
        rv = findViewById(R.id.recyclerView);
        miLayoutManager =new GridLayoutManager(this, 1);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(miAdaptador);
        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ab.isShowing()){
                    ab.hide();
                } else {
                    ab.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ab = getSupportActionBar();
        return super.onOptionsItemSelected(item);
    }

}