package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class Fase {

    private List<Ronda> rondas;
    private int numeroFase;

    public Fase(int numeroFase){
        this.rondas = new ArrayList<>();
        this.numeroFase = numeroFase;
    }

    public int getNumeroFase(){
        return numeroFase;
    }

    public void agregarRonda(Ronda ronda) {
        for(Ronda r : this.rondas){
            if(r.getNumeroRonda() == ronda.getNumeroRonda()){
                throw new RuntimeException("Ronda ya existente");
            }
        }
        this.rondas.add(ronda);
    }

    public Ronda obtenerRonda(int numeroRonda) {
        Ronda ronda = null;
        for(Ronda r : this.rondas){
            if(r.getNumeroRonda()==numeroRonda){
                ronda = r;
            }
        }
        if(ronda==null){
            throw new RuntimeException("No existe la ronda");
        }
        return ronda;
    }
}
