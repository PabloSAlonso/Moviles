package com.example.iniciardistintosmains;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button boton;
    int num;
    Intent lanzarActividad;
    EditText et;
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

        ActivityResultLauncher<Intent> launcher=registerForActivityResult(new
                ActivityResultContracts.StartActivityForResult(),new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK){
                    Intent obtenerDevolucion = result.getData();
                    int numEstrellas = (int) obtenerDevolucion.getFloatExtra("estrellas",0);
                    switch (numEstrellas){
                        case 0:
                            Log.i("PRUEBA","ME ENCUENTRO LUGONPA");
                            break;
                        case 1:
                            Log.i("PRUEBA", "ME ENCUENTRO MAL");
                            break;
                        case 2:
                            Log.i("PRUEBA","ME ENCUENTRO NORMAL");
                            break;
                        case 3:
                            Log.i("PRUEBA","ME ENCUENTRO DECENTE");
                            break;
                        case 4:
                            Log.i("PRUEBA","ME ENCUENTRO BIEN");
                            break;
                        case 5:
                            Log.i("PRUEBA","ME ENCUENTRO COSTA");
                            break;
                        default:
                            break;
                    }
                }
            }
        });



        boton = findViewById(R.id.button);
        num = 5;
        et = findViewById(R.id.editTextText);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarActividad = new Intent(MainActivity.this, MainActivity2.class);
                //lanzarActividad.putExtra("numero", num);
                //lanzarActividad.putExtra("texto",et.getText().toString());
                //startActivity(lanzarActividad);
                launcher.launch(lanzarActividad);
            }
        });
    }
}