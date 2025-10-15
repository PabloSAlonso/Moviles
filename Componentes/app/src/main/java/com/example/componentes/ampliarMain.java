package com.example.componentes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ampliarMain extends AppCompatActivity {
    Button btn;
    RatingBar rb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ampliar_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rb = findViewById(R.id.rtb2);
        tv = findViewById(R.id.txtResultado);
        btn = findViewById(R.id.btnAmpliar);
        Intent intSec = getIntent();
        String cadena = intSec.getStringExtra("imageButtonET");
        Float num = intSec.getFloatExtra("imageButtonEstrellas",2);

        tv.setText(cadena);
        rb.setRating(num);

        ActivityResultLauncher<Intent> launcher=registerForActivityResult(new
                ActivityResultContracts.StartActivityForResult(),new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK){
                    Intent obtenerDevolucion = result.getData();
                    rb.setRating(obtenerDevolucion.getFloatExtra("imageButtonEstrellas",3));
                    tv.setText(obtenerDevolucion.getStringExtra("imageButtonET"));
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devolverNuevoResult = new Intent();
                devolverNuevoResult.putExtra("imageButtonEstrellas", rb.getRating());
                setResult(RESULT_OK,devolverNuevoResult);
                finish();
            }
        });
        Intent intent = new Intent(ampliarMain.this, MainActivity.class);
        intent.getFloatExtra("ch1status",0);
        intent.getFloatExtra("ch2status",0);
        intent.getFloatExtra("ch3status",0);
    }
}