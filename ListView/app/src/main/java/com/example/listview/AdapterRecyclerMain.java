package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterRecyclerMain extends RecyclerView.Adapter<AdapterRecyclerMain.MyViewHolder>{
    ArrayList<PilotoF1> pilotos;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView edad;
        private TextView escuderia;
        private ImageView cara;

        public MyViewHolder(View view){
            super(view);
            this.nombre = view.findViewById(R.id.txvNombre);
            this.edad = view.findViewById(R.id.txvEdad);
            this.escuderia = view.findViewById(R.id.txvEscu);
            this.cara = view.findViewById(R.id.imgCara);
        }

        public TextView getNombre(){
            return nombre;
        }
        public TextView getEdad(){
            return edad;
        }
        public TextView getEscuderia(){
            return escuderia;
        }
        public ImageView getCara(){
            return cara;
        }
    }
    public AdapterRecyclerMain(ArrayList<PilotoF1> pilotos){
        this.pilotos = pilotos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda,
                parent, false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PilotoF1 pilotos = this.pilotos.get(position);
        holder.getNombre().setText(pilotos.getNombre());
        holder.getEdad().setText(pilotos.getEdad()+"");
        holder.getEscuderia().setText(pilotos.getEscuderia());
        holder.getCara().setImageResource(pilotos.getImagenPiloto());
    }

    @Override
    public int getItemCount() {
        return this.pilotos.size();
    }
}
