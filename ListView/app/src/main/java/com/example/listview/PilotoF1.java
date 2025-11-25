package com.example.listview;

import java.io.Serializable;
import java.util.ArrayList;

public class PilotoF1 implements Serializable {
    private String nombre;
    private int edad;
    private String escuderia;
    private int imagenPiloto;

    public PilotoF1(String nombre, int edad, String escuderia, int imagenPiloto) {
        this.nombre = nombre;
        this.edad = edad;
        this.escuderia = escuderia;
        this.imagenPiloto = imagenPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public int getImagenPiloto() {
        return imagenPiloto;
    }

    public static ArrayList<PilotoF1> cargarPilotos() {
        ArrayList<PilotoF1> lista = new ArrayList<>();
        lista.add(new PilotoF1("Max Verstappen", 27, "Red Bull", R.drawable.debian));
        lista.add(new PilotoF1("Sergio Pérez", 34, "Red Bull", R.drawable.w7));
        lista.add(new PilotoF1("Lewis Hamilton", 40, "Mercedes", R.drawable.ios8));
        lista.add(new PilotoF1("George Russell", 27, "Mercedes", R.drawable.maxx));
        lista.add(new PilotoF1("Charles Leclerc", 27, "Ferrari", R.drawable.wxp));
        lista.add(new PilotoF1("Carlos Sainz", 30, "Ferrari", R.drawable.ubuntu14));
        lista.add(new PilotoF1("Lando Norris", 26, "McLaren", R.drawable.wvista));
        lista.add(new PilotoF1("Oscar Piastri", 24, "McLaren", R.drawable.w98));
        lista.add(new PilotoF1("Fernando Alonso", 43, "Aston Martin", R.drawable.w11));
        lista.add(new PilotoF1("Lance Stroll", 27, "Aston Martin", R.drawable.w95));
        lista.add(new PilotoF1("Pierre Gasly", 29, "Alpine", R.drawable.new_item));
        lista.add(new PilotoF1("Esteban Ocon", 29, "Alpine", R.drawable.w10));
        return lista;
    }

    public static void main(String[] args) {
        ArrayList<PilotoF1> pilotos = PilotoF1.cargarPilotos();
        for (PilotoF1 p : pilotos) {
            System.out.println(p.getNombre() + " - " + p.getEscuderia());
        }
    }
}
