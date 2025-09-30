package com.example.componentes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView txtView;
    Button btn1;
    Button btnImagen;
    ImageButton imgBtn;
    ToggleButton tglBtn;
    CheckBox chBox1;
    CheckBox chBox2;
    CheckBox chBox3;
    RadioButton rdBtn1;
    RadioButton rdBtn2;
    Switch switch1;
    SeekBar seekBar1;
    RatingBar ratingBar1;
    EditText editText1;
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
        toolbar = findViewById(R.id.toolBar);
        txtView = findViewById(R.id.txtView);
        btn1 = findViewById(R.id.btn1);
        btnImagen = findViewById(R.id.btnImagen);
        imgBtn = findViewById(R.id.imgBtn);
        tglBtn = findViewById(R.id.tglBtn);
        chBox1 = findViewById(R.id.chBox1);
        chBox2 = findViewById(R.id.chBox2);
        chBox3 = findViewById(R.id.chBox3);
        rdBtn1 = findViewById(R.id.rdBtn1);
        rdBtn2 = findViewById(R.id.rdBtn2);
        switch1 = findViewById(R.id.switch1);
        seekBar1 = findViewById(R.id.seekBar1);
        ratingBar1 = findViewById(R.id.ratingBar1);
        editText1 = findViewById(R.id.editText1);
    }
}