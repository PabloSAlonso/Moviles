package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView l;
    ArrayList<String> listaString = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Toolbar toolbar;

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
        l = findViewById(R.id.list);
        String[]contactos = new String[] {"Italiani", "Costa", "Lugonpa", "AaTuprima", "Montes", "broder", "La calva de Curro", "Monster blanco"};
        for (int i = 0; i < contactos.length; i++) {
            listaString.add(contactos[i]);
        }
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, listaString);
        l.setAdapter(adapter);
        l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has seleccionado al numero:"+position+1, Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
            }
        });
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.borrar) {
            for (int i = l.getCount() -1 ; i >=0 ;i--) {
                if (l.isItemChecked(i)){
                    listaString.remove(i);
                }
            }
            l.getCheckedItemPositions().clear();
            adapter.notifyDataSetChanged();
        }
        adapter.notifyDataSetChanged();
        return false;
    }

}