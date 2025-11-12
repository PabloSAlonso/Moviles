package com.example.ejerciciofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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
        peliculas = Datos.rellenaPeliculas();
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
        listadoFav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (listadoFav.isItemChecked(position)){
                    peliculas.get(position).setFavorita(true);
                    adapter.notifyDataSetChanged();
                } else {
                    peliculas.get(position).setFavorita(false);
                    adapter.notifyDataSetChanged();
                }
                adapter.notifyDataSetChanged();
            }
        });
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new
                ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode()==RESULT_OK){
                    Intent devolverFavs = result.getData();
                    for (int i = 0; i < peliculas.size(); i++) {
                        //Pasar clave
                        peliculas.get(i).favorita = (boolean)devolverFavs.getBooleanExtra("",peliculas.get(i).getFavorita()) ;
                    }
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
        }
        return super.onOptionsItemSelected(item);
    }
}