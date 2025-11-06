package com.example.ejerciciofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MiAdaptadorListado extends RecyclerView.Adapter<MiAdaptadorListado.MyViewHolder> {
    ArrayList<Pelicula> peliculas;
    public MiAdaptadorListado(ArrayList<Pelicula> peliculas){
        this.peliculas =peliculas;
    }
    int selectedPos = RecyclerView.NO_POSITION;
    public int getSelectedPos() {
        return selectedPos;
    }
    public void setSelectedPos(int selectedPos){
        if (selectedPos == this.selectedPos) {
            this.selectedPos = RecyclerView.NO_POSITION;
            notifyItemChanged(selectedPos);
        } else {
            if (this.selectedPos != RecyclerView.NO_POSITION){
                notifyItemChanged(this.selectedPos);
            }
            this.selectedPos = selectedPos;
            notifyItemChanged(selectedPos);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda,parent,false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvDir, tvDur,tvSala,tvFech;
        ImageView ivCaratula, ivEdad, ivFavs;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDir = itemView.findViewById(R.id.tvDirector);
            tvDur = itemView.findViewById(R.id.tvDuracion);
            tvSala = itemView.findViewById(R.id.tvSala);
            tvFech = itemView.findViewById(R.id.tvFecha);
            ivCaratula = itemView.findViewById(R.id.ivCaratula);
            ivEdad = itemView.findViewById(R.id.ivEdad);
            ivFavs = itemView.findViewById(R.id.ivFav);
        }
        public TextView getTvDir(){
            return tvDir;
        }
        public TextView getTvDur(){
            return tvDur;
        }
        public TextView getTvSala(){
            return tvSala;
        }
        public TextView getTvFech(){
            return tvFech;
        }
        public ImageView getIvCaratula(){
            return ivCaratula;
        }
        public ImageView getIvEdad(){
            return ivCaratula;
        }
        public ImageView getIvFavs(){
            //Hay que ver si esa peli está en favoritos para decidir si cogemos
            // esta imageview o no (creo)
            //if (listaFavs.contains(pelicula)) {
                return ivFavs;
            //}
        }
    }


    @Override
    public void onBindViewHolder(@NonNull MiAdaptadorListado.MyViewHolder holder, int position) {
        Pelicula p = this.peliculas.get(position);
        if (selectedPos == position){
            holder.itemView.setBackgroundResource(R.color.gray);
        } else {
            holder.itemView.setBackgroundResource(R.color.green);
        }
    }

    @Override
    public int getItemCount() {
        return this.peliculas.size();
    }
}
