package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<PilotoF1> pilotos;
    RecyclerView rv;
    Toolbar tb;
    AdapterRecyclerMain adaptador;

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
        pilotos = PilotoF1.cargarPilotos();
        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar actionBar = getSupportActionBar();
        rv = findViewById(R.id.recyclerView);
        adaptador = new AdapterRecyclerMain(pilotos);
        GridLayoutManager miLayoutManager =new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, true);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode()==RESULT_OK){
                Intent intent = o.getData();
                ArrayList<PilotoF1> pilotosMod = (ArrayList<PilotoF1>) intent.getSerializableExtra("pilotosMod");
                pilotos.clear();
                pilotos.addAll(pilotosMod);
                adaptador.notifyDataSetChanged();
            }
        }
    });

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.lanzar_listview) {
            Intent lanzarListView = new Intent();
            lanzarListView.putExtra("pilotos", pilotos);
            launcher.launch(lanzarListView);
            return true;
        }
        adapter.notifyDataSetChanged();
        return false;
    }

}