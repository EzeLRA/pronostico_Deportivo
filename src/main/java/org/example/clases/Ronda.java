package org.example.clases;

import java.util.List;
import java.util.ArrayList;

public class Ronda {

    private  int numeroRonda;

    private List<Partido> partidos;

    public Ronda(int numeroRonda){
        this.numeroRonda = numeroRonda;
        this.partidos = new ArrayList<>();
    }

    public void agregarPartido(Partido partido){
        for(Partido p : this.partidos){
            if(p.igual(partido)){
                throw new RuntimeException("Ya existe el partido");
            }
        }
        this.partidos.add(partido);
    }

    public int getNumeroRonda(){
        return numeroRonda;
    }

    public Partido obtenerPartido(String equipo1, String equipo2) {

        Partido partido = null;

        for(Partido p : this.partidos){
            if(p.juegan(equipo1,equipo2)) {
                partido = p;
            }
        }

        if(partido == null){
            throw new RuntimeException("No existe el partido");
        }
        return partido;
    }
}
