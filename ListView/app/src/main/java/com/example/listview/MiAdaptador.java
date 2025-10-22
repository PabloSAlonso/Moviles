package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder>{
    ArrayList<SistemaOperativo> sistemasOperativos;
    public MiAdaptador(ArrayList<SistemaOperativo> sistemasOperativos) {
        this.sistemasOperativos = sistemasOperativos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento= LayoutInflater.from(parent.getContext()).inflate(R.layout.celda,
                parent, false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SistemaOperativo so = this.sistemasOperativos.get(position);
        holder.obtenerNombre().setText(so.getNombre());
        holder.obtenerEdad().setText(so.getAno()+"");
        holder.obtenerLogo().setImageResource(so.getLogo());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEdad;
        ImageView imLogo;

        public MyViewHolder(View viewElemento){
            super(viewElemento);
            tvNombre = viewElemento.findViewById(R.id.textView);
            tvEdad = viewElemento.findViewById(R.id.textView2);
            imLogo = viewElemento.findViewById(R.id.imageView);
        }
        public TextView obtenerNombre(){
            return tvNombre;
        }
        public TextView obtenerEdad(){
            return  tvEdad;
        }
        public ImageView obtenerLogo(){
            return  imLogo;
        }
    }
}
