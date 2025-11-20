package com.example.ejerciciofinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Toolbar tb;
    ImageButton boton;
    RecyclerView.LayoutManager miLayoutManager;
    MiAdaptador miAdaptador;
    ArrayList<Pelicula>peliculas;
    ArrayList<Pelicula>peliculasAux;
    ActionBar ab;
    TextView seccionFija;
    ActivityResultLauncher<Intent> launcher;
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
        peliculasAux = new ArrayList<>();
        peliculas = Datos.rellenaPeliculas();
        seccionFija = findViewById(R.id.tvSeccionFija);
        miAdaptador = new MiAdaptador(peliculas, seccionFija);
        boton = findViewById(R.id.btnActionBar);
        rv = findViewById(R.id.recyclerView);
        miLayoutManager =new GridLayoutManager(this, 1);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(miAdaptador);
        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ab = getSupportActionBar();


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ab.isShowing()){
                    ab.hide();
                    boton.setImageResource(R.drawable.g);
                } else {
                    ab.show();
                    boton.setImageResource(R.drawable.r);
                }
            }
        });
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK){
                    Intent i = o.getData();
                    peliculasAux = (ArrayList<Pelicula>) i.getSerializableExtra("pelis_nuevas_favs");
                    peliculas.clear();
                    for (int j = 0; j < peliculasAux.size(); j++) {
                        peliculas.add(peliculasAux.get(j));
                    }
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
        if (item.getItemId() == R.id.listado){
            Intent vaAlistado = new Intent();
            vaAlistado.putExtra("pelis_main", peliculas);
            setResult(RESULT_OK, vaAlistado);
            finish();

            Intent lanzarListado = new Intent(MainActivity.this, RecyclerListado.class);
            startActivity(lanzarListado);
        } else if(item.getItemId() == R.id.favoritos){

            Intent devolverPelis = new Intent(MainActivity.this, ListadoFavoritos.class);
            devolverPelis.putExtra("pelis",peliculas);
            launcher.launch(devolverPelis);
        } else if(item.getItemId() == R.id.añadir){

        } else if(item.getItemId() == R.id.mostrarCol){

        } else if(item.getItemId() == R.id.mostrarFav){

        }


        return super.onOptionsItemSelected(item);
    }


}