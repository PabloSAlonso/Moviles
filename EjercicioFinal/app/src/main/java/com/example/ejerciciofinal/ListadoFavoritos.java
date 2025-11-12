package com.example.ejerciciofinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListadoFavoritos extends AppCompatActivity {
    ListView listadoFav;
    Toolbar tb;
    ActionBar ab;
    ArrayList<Pelicula>peliculas;
    ArrayAdapter<String> adapter;
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listado_favoritos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        peliculas = new ArrayList<>();
        Intent peliculasDevueltas = getIntent();
        peliculas = (ArrayList<Pelicula>) peliculasDevueltas.getSerializableExtra("pelis");
        ArrayList<String> tituloYdir = new ArrayList<>();
        for (int i = 0; i < peliculas.size(); i++) {
            tituloYdir.add(String.format("Título: %s, Director: %s", peliculas.get(i).titulo, peliculas.get(i).director));
        }
        listadoFav = findViewById(R.id.listadoFavs);
        tb = findViewById(R.id.tbFavs);
        setSupportActionBar(tb);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        adapter = new ArrayAdapter<>(ListadoFavoritos.this, android.R.layout.simple_list_item_multiple_choice, tituloYdir);
        listadoFav.setAdapter(adapter);
        listadoFav.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getFavorita()){
                listadoFav.setItemChecked(i, true);
                adapter.notifyDataSetChanged();
            }
        }
        //
        listadoFav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < listadoFav.getCheckedItemPositions().size(); i++){
                    peliculas.get(i).setFavorita(true);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_volver,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home ) {
            onBackPressed();
            return true;
        } else if (id == R.id.volverGuardando) {
            //Actividad que devuelve las nuevas pelis chequeadas
            Intent vuelvenAlMain = new Intent();
            vuelvenAlMain.putExtra("pelis_nuevas_favs", peliculas);
            setResult(RESULT_OK, vuelvenAlMain);
            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}