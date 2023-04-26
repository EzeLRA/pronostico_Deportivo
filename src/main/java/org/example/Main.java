package org.example;

import org.example.clases.Persona;
import org.example.clases.Pronostico;
import org.example.utilidades.LectorBD;
import org.example.utilidades.LectorCSV;

public class Main {
    public static void main(String[] args) {

        int puntajePorPartido = 2;
        int puntajeExtraRonda = 10;
        int puntajeExtraFase = 20;

        LectorCSV lectorCSV = new LectorCSV();
        lectorCSV.imprimirResultados();

        LectorBD lectorBD = new LectorBD(lectorCSV);
        lectorBD.imprimirPronosticos();

        calcularPuntos(lectorBD,puntajePorPartido,puntajeExtraRonda,puntajeExtraFase);

    }

    private static void calcularPuntos(LectorBD lectorBD , int puntajePorPartido, int puntajeExtraRonda,int puntajeExtraFase) {
        for(Pronostico p: lectorBD.getPronosticos()){
            if(p.fueAcertado()){
                p.getPersona().sumarPuntos(puntajePorPartido);
                p.getPersona().agregarAcierto();
            }
        }
        /*
        Debera analizar para agregar puntajes extras

        for(Persona p : lectorBD.getPersonas()){

            analiza las rondas

            for(rondas : todas las rondas existentes)
            if(lectorBD.aciertoCompletoPronosticoRonda(p,ronda)){
                p.sumarPuntos(puntajeExtraRonda);
            }
        }

            for(fases : todas las fases existentes){
            if(lectorBD.aciertoCompletoPronosticoFases(p,fase)){
                p.sumarPuntos(puntajeExtraFase);
            }
           }

         */
        for(Persona p:lectorBD.getPersonas()){
            System.out.println("Nombre"+ p.getNombre());
            System.out.println("Aciertos"+ p.getAciertos());
            System.out.println("Puntaje"+ p.getPuntos());
            System.out.println("----");
        }


    }
}