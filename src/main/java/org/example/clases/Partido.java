package org.example.clases;

public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;

    private int goles1;
    private int goles2;

    public Partido(Equipo equipo1,Equipo equipo2,int goles1,int goles2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.goles1 = goles1;
        this.goles2 = goles2;
    }

    public Equipo getEquipo1(){
        return equipo1;
    }

    public Equipo getEquipo2(){
        return equipo2;
    }

    public int getGoles1(){
        return goles1;
    }

    public int getGoles2(){
        return goles2;
    }

    public boolean igual(Partido p){
        return (this.equipo1.getNombre().equals(p.equipo1.getNombre()) && this.equipo2.getNombre().equals(p.equipo2.getNombre()) )
                ||(this.equipo2.getNombre().equals(p.equipo2.getNombre()) && this.equipo1.getNombre().equals(p.equipo1.getNombre()));
    }

    public boolean juegan(String equipo1, String equipo2) {
        return (this.equipo1.getNombre().equals(equipo1) && this.equipo2.getNombre().equals(equipo2))
                ||(this.equipo2.getNombre().equals(equipo2) && this.equipo1.getNombre().equals(equipo1));
    }

    public Resultado getResultado() {
        if(goles1 > goles2){
            return Resultado.GANA1;
        }else if(goles1 < goles2){
            return Resultado.GANA2;
        }else{
            return Resultado.EMPATE;
        }
    }
}
