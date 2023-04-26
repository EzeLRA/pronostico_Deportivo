package org.example.utilidades;

import org.example.clases.Equipo;
import org.example.clases.Fase;
import org.example.clases.Partido;
import org.example.clases.Ronda;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {


    //Atributos
    private BufferedReader lector;    //Lector de archivos
    private String linea;             //Lineas de cada fila
    private String palabras[] = null; //Palabras de las celdas

    List<Fase> fases;
    List<Equipo> equipos;

    public LectorCSV(){
        this.fases = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }

    //Metodo lector de archivos
    public String leerArchivo(String nombreArchivo, int pos,String clave){
        String salida = "";

        try{
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while((linea = lector.readLine())!= null){
                palabras = linea.split(";");
                salida = palabras[pos];
            }
            lector.close();
            linea = null;
            palabras = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return salida;
    }



    //Metodo de impresion(De prueba)
    public void Imprimir(){
        for(int i=0 ; i < palabras.length;i++){
            System.out.printf(palabras[i]+" / ");
        }
    }

    public void imprimirResultados() {
        Equipo argentina = this.obtenerEquipo("Argentina");
        Equipo arabia = this.obtenerEquipo("Arabia Saudita");
        Equipo polonia = this.obtenerEquipo("Polonia");
        Equipo mexico = this.obtenerEquipo("Mexico");

        Partido partido1 = new Partido(argentina,arabia,1,2);
        Partido partido2 = new Partido(polonia,mexico,0,0);
        Partido partido3 = new Partido(argentina,mexico,2,0);
        Partido partido4 = new Partido(arabia,polonia,0,2);

        Ronda ronda1 = new Ronda(1);

        ronda1.agregarPartido(partido1);
        ronda1.agregarPartido(partido2);
        ronda1.agregarPartido(partido3);
        ronda1.agregarPartido(partido4);

        Fase fase1 = new Fase(1);
        fase1.agregarRonda(ronda1);

        this.agregarFase(fase1);

    }

    private void agregarFase(Fase fase) {
        for(Fase f:this.fases){
            if(f.getNumeroFase()==fase.getNumeroFase()){
                throw new RuntimeException("Ya existe la fase");
            }
        }
        this.fases.add(fase);
    }

    private Equipo obtenerEquipo(String nombreEquipo) {

        Equipo equipo = null;

        for(Equipo e : this.equipos){
            if(e.getNombre().equals(nombreEquipo)){
                equipo = e;
            }
        }
        if(equipo==null){
            equipo = new Equipo(nombreEquipo);
            this.equipos.add(equipo);
        }

        return equipo;

    }

    public Fase obtenerFase(int numeroFase) {
        Fase fase = null;
        for(Fase f : this.fases){
            if(f.getNumeroFase() == numeroFase){
                fase = f;
            }
        }

        if(fase == null){
            throw new RuntimeException("No existe la fase");
        }

        return fase;

    }
}
