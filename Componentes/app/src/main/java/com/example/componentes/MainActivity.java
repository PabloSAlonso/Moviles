package com.example.componentes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText ett;
    Button btt;
    Button btt2;
    ImageButton ibtt;
    ToggleButton tb;
    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;

    RadioButton rb1;
    RadioButton rb2;
    SeekBar sb;
    RatingBar rt;
    TextView tv;
    TextView tv2;
    Switch sw;

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
        toolbar = findViewById(R.id.toolBar);
        tb=findViewById(R.id.tooglebtn);
        ch1=findViewById(R.id.checkBox1);
        ch2=findViewById(R.id.checkBox2);
        ch3=findViewById(R.id.checkBox3);
        sb=findViewById(R.id.seekBar);
        tv=findViewById(R.id.tv);
        tv2=findViewById(R.id.textView2);
        sw=findViewById(R.id.switch1);
        btt=findViewById(R.id.button);
        btt2=findViewById(R.id.button2);
        rb1=findViewById(R.id.radioButton3);
        rb2=findViewById(R.id.radioButton4);
        rt=findViewById(R.id.ratingBar);
        ett=findViewById(R.id.editTextText);
        ibtt=findViewById(R.id.imageButton);

        ibtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lanzarEvento = new Intent(MainActivity.this, ampliarMain.class);
                lanzarEvento.putExtra();

            }
        });

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ch1.setChecked(tb.isChecked());
                ch3.setEnabled(tb.isChecked());
            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(sb.getProgress()+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw.isChecked()){
                    sw.setText("activo");
                }else{
                    sw.setText("desactivo");
                }
            }
        });

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tb.isChecked()){
                    tb.setChecked(false);
                }
                if (ch1.isChecked()){
                    ch1.setChecked(false);
                }
                if (ch2.isChecked()){
                    ch2.setChecked(false);
                }
                if (ch3.isChecked()){
                    ch3.setChecked(false);
                }
                if(rb1.isChecked()){
                    rb1.setChecked(false);
                }
                if (rb2.isChecked()){
                    rb2.setChecked(false);
                }
                if (sb.getProgress()!=0){
                    sb.setProgress(0);
                }
                if(rt.getProgress()!=0){
                    rt.setProgress(0);
                }
                if(!ett.getText().equals("")){
                    ett.setText("");
                }
                btt2.setText("Button");
            }
        });

        ibtt.setOnClickListener(new View.OnClickListener() {
            int contador=0;

            @Override
            public void onClick(View v) {


                if (ch2.isChecked()){
                    contador--;
                    btt2.setText(contador+"");
                }else{
                    contador++;
                    btt2.setText(contador +"");
                }
            }

        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "radioButton 1", Toast.LENGTH_SHORT).show();
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "radioButton 2", Toast.LENGTH_SHORT).show();
            }
        });

    }

}