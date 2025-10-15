package com.example.pruebasss;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnPosicion, btnPosicion2, btnPosicion3, btnPosicion4;
    Toolbar tb;

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

        btnPosicion =(Button)findViewById(R.id.button);
        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Double lat = 42.237109;
                Double lon = -8.723474;
                int zoom = 22;
                String label = "MiPunto";
                // try { label=URLEncoder.encode("label","UTF-8");
                // } catch (UnsupportedEncodingException e){}
                String uri = String.format(Locale.US,
                        "geo:%f,%f?z=%d&q=%f,%f(%s)", lat, lon, zoom, lat, lon, label);
                intent.setData(Uri.parse(uri));
                // Si existe una Activity que es capaz de gestionar los datos esta se lanza
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });
        btnPosicion2 = findViewById(R.id.button2);
        btnPosicion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "¡Hola Mundo!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        btnPosicion3 = findViewById(R.id.button3);

        btnPosicion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se requiere el permiso com.android.alarm.permission.SET_ALARM
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE,"¡¡ Hora de levantarse !!")
                        .putExtra(AlarmClock.EXTRA_HOUR,7)
                        .putExtra(AlarmClock.EXTRA_MINUTES,30);
                if(intent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(intent);
                }
            }
        });
        btnPosicion4 = findViewById(R.id.button4);
        tb = findViewById(R.id.toolbar2);
        setSupportActionBar(tb);
        btnPosicion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                // Intent intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
                if(intent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menuprueba,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.mEditar){
            Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id==R.id.mBorrar){
            Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id==R.id.mOtro){
            Toast.makeText(this, "Otro", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id==R.id.subMenu){
            Toast.makeText(this, "Submenú 1", Toast.LENGTH_SHORT).show();
            return true;
        };
        return super.onOptionsItemSelected(item);
    }
}
