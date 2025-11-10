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


public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder>{
    ArrayList<SistemaOperativo> sistemasOperativos;
    public MiAdaptador(ArrayList<SistemaOperativo> sistemasOperativos) {
        this.sistemasOperativos = sistemasOperativos;
    }

    int selectedPos = RecyclerView.NO_POSITION;
    public int getSelectedPos(){
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
        View elemento= LayoutInflater.from(parent.getContext()).inflate(R.layout.celda,
                parent, false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh ;
    }

    //Donde se le añaden los datos a cada celda
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SistemaOperativo so = this.sistemasOperativos.get(position);
        holder.obtenerNombre().setText(so.getNombre());
        holder.obtenerEdad().setText(so.getAno()+"");
        holder.obtenerLogo().setImageResource(so.getLogo());

        if (selectedPos == position){
            holder.itemView.setBackgroundResource(R.color.gray);
        } else {
            holder.itemView.setBackgroundResource(R.color.green);
        }
    }

    @Override
    public int getItemCount() {
        return this.sistemasOperativos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEdad;
        ImageView imLogo;

        //Identificamos cada textview e imagen
        public MyViewHolder(View viewElemento){
            super(viewElemento);
            tvNombre = viewElemento.findViewById(R.id.textView);
            tvEdad = viewElemento.findViewById(R.id.textView2);
            imLogo = viewElemento.findViewById(R.id.imageView);

            viewElemento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posPulsada = getAdapterPosition();
                    setSelectedPos(posPulsada);
                    Toast.makeText(v.getContext(),sistemasOperativos.get(posPulsada).getNombre(),Toast.LENGTH_LONG).show();
                }
            });
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
