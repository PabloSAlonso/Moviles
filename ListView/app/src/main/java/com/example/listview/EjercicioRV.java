package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

public class EjercicioRV extends AppCompatActivity {
    ArrayList<SistemaOperativo> sistemas;
    RecyclerView rv;
    MiAdaptador miAdaptador;
    RecyclerView.LayoutManager miLayoutManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rellenaDatos(10);
        miAdaptador=new MiAdaptador(sistemas);
        rv=findViewById(R.id.rv);
        miLayoutManager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(miAdaptador);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menurecyclerview,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int pos = miAdaptador.selectedPos;
        ActionBar ab = getSupportActionBar();
        if (miAdaptador.getSelectedPos() != RecyclerView.NO_POSITION){
            if (item.getItemId() == R.id.añadir){
                sistemas.add(pos,new SistemaOperativo("nuevo" + pos, String.valueOf(pos),R.drawable.new_item));
                miAdaptador.notifyItemInserted(pos);
            } else if (item.getItemId() == R.id.eliminar){
                sistemas.remove(pos);
                miAdaptador.notifyItemRemoved(pos);
                miAdaptador.setSelectedPos(RecyclerView.NO_POSITION);
            } else if (item.getItemId() == R.id.editar){
                sistemas.get(pos).setNombre("Nombre Modificado");
                miAdaptador.notifyItemChanged(pos);
            } else if(item.getItemId() == R.id.mover){
                SistemaOperativo aux = sistemas.get(pos);
                int nuevaPos = 0;
                sistemas.remove(pos);
                sistemas.add(nuevaPos,aux);
                miAdaptador.notifyItemChanged(pos);
                miAdaptador.notifyItemMoved(pos,nuevaPos);
                miAdaptador.setSelectedPos(nuevaPos);

            }
        } else {
            Log.i("ERROR MENU", "POSICION NO SELECCIONADA");
        }
        ab.setTitle("Tam: " + sistemas.size());
        ab.setSubtitle("Pos: " + miAdaptador.getSelectedPos());
        return true;
    }

    public void rellenaDatos(int vueltas) {
        sistemas = new ArrayList<SistemaOperativo>();
        for (int i = 1; i <= vueltas; i++) {
            sistemas.add(new SistemaOperativo("Ubuntu 14 " + i, "2014", R.drawable.ubuntu14));
            sistemas.add(new SistemaOperativo("MacOS X " + i, "2004", R.drawable.maxx));
            sistemas.add(new SistemaOperativo("Windows 95 " + i, "1995", R.drawable.w95));
            sistemas.add(new SistemaOperativo("Debian " + i, "1993", R.drawable.debian));
            sistemas.add(new SistemaOperativo("Windows 98 " + i, "1998", R.drawable.w98));
            sistemas.add(new SistemaOperativo("Linux Mint 15 " + i, "2013", R.drawable.mint));
            sistemas.add(new SistemaOperativo("Windows 10 " + i, "2016", R.drawable.w10));
            sistemas.add(new SistemaOperativo("Android " + i, "2006", R.drawable.android));
            sistemas.add(new SistemaOperativo("iOS 8 " + i, "2014", R.drawable.ios8));
            sistemas.add(new SistemaOperativo("Windows Vista " + i, "2007", R.drawable.wvista));
            sistemas.add(new SistemaOperativo("Windows XP " + i, "2001", R.drawable.wxp));
            sistemas.add(new SistemaOperativo("Elementary " + i, "2014", R.drawable.elementary));
            sistemas.add(new SistemaOperativo("Ubuntu 20 " + i, "2020", R.drawable.ubuntu20));
            sistemas.add(new SistemaOperativo("Windows 11 " + i, "2021", R.drawable.w11));
        }
    }
}