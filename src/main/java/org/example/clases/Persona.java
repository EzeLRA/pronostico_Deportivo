package org.example.clases;

public class Persona {

    private String nombre;

    private int puntos;

    private int aciertos;

    public Persona(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
        this.aciertos = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntos(){
        return puntos;
    }

    public int getAciertos(){
        return aciertos;
    }

    public void sumarPuntos(int puntajeNuevo) {
        this.puntos += puntajeNuevo;
    }

    public void agregarAcierto(){
        this.aciertos++;
    }

}
