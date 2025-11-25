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

        lista.add(new PilotoF1("Max Verstappen", 27, "Red Bull", 1));
        lista.add(new PilotoF1("Sergio Pérez", 34, "Red Bull", 2));
        lista.add(new PilotoF1("Lewis Hamilton", 40, "Mercedes", 3));
        lista.add(new PilotoF1("George Russell", 27, "Mercedes", 4));
        lista.add(new PilotoF1("Charles Leclerc", 27, "Ferrari", 5));
        lista.add(new PilotoF1("Carlos Sainz", 30, "Ferrari", 6));
        lista.add(new PilotoF1("Lando Norris", 26, "McLaren", 7));
        lista.add(new PilotoF1("Oscar Piastri", 24, "McLaren", 8));
        lista.add(new PilotoF1("Fernando Alonso", 43, "Aston Martin", 9));
        lista.add(new PilotoF1("Lance Stroll", 27, "Aston Martin", 10));
        lista.add(new PilotoF1("Pierre Gasly", 29, "Alpine", 11));
        lista.add(new PilotoF1("Esteban Ocon", 29, "Alpine", 12));
        return lista;
    }

    public static void main(String[] args) {
        ArrayList<PilotoF1> pilotos = PilotoF1.cargarPilotos();
        for (PilotoF1 p : pilotos) {
            System.out.println(p.getNombre() + " - " + p.getEscuderia());
        }
    }
}
