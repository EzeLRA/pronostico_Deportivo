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

}
