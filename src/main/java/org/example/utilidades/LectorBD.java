package org.example.utilidades;

import org.example.clases.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LectorBD {

    private List<Pronostico> pronosticos;
    private List<Persona> personas;

    private LectorCSV lectorCSV;

    public LectorBD(LectorCSV lectorCSV) {
        this.lectorCSV = lectorCSV;
        this.pronosticos = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public boolean aciertoCompletoPronosticoRonda(Persona p,int ronda){
        List<Pronostico> pronosticos1 = this.pronosticos.stream().filter(
                pronostico ->
                    pronostico.getPersona().equals(p)
        ).toList();

        pronosticos1 = pronosticos1.stream().filter(
                pronostico -> pronostico.getRonda().getNumeroRonda() == ronda
        ).toList();

        return pronosticos1.stream().allMatch(pronostico -> pronostico.fueAcertado());
    }

    public boolean aciertoCompletoPronosticoFase(Persona p,int fase){
        List<Pronostico> pronosticos1 = this.pronosticos.stream().filter(
                pronostico ->
                        pronostico.getPersona().equals(p)
        ).toList();

        pronosticos1 = pronosticos1.stream().filter(
                pronostico -> pronostico.getFase().getNumeroFase() == fase
        ).toList();

        return pronosticos1.stream().allMatch(pronostico -> pronostico.fueAcertado());
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void imprimirPronosticos(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pronosticos","root","eze_LRA842._.");
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("select * from pronosticos");

            while(resultado.next()){
                Fase fase = lectorCSV.obtenerFase(resultado.getInt("fase"));
                Ronda ronda = fase.obtenerRonda(resultado.getInt("ronda"));
                Persona persona = this.obtenerPersona(resultado.getString("persona"));
                Partido partido = ronda.obtenerPartido(
                        resultado.getString("equipo1"),
                        resultado.getString("equipo2")
                        );

                boolean gana1 = resultado.getBoolean("gana1");
                boolean empata = resultado.getBoolean("empata");
                boolean gana2 = resultado.getBoolean("gana2");

                Resultado res = null;

                if(gana1){
                    res = Resultado.GANA1;
                }else if(gana2){
                    res = Resultado.GANA2;
                }else if(empata){
                    res = Resultado.EMPATE;
                }else{
                    throw new RuntimeException("No se establecio un resultado");
                }

                Pronostico pronostico = new Pronostico(fase,ronda,persona,partido,res);
                this.agregarPronostico(pronostico);

            }


            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void agregarPronostico(Pronostico pronostico) {
        for(Pronostico p : this.pronosticos){
            if(p.getFase().equals(pronostico.getFase())
                    && p.getPartido().equals(pronostico.getPartido())
                    && p.getRonda().equals(pronostico.getRonda())
                    && p.getPersona().equals(pronostico.getPersona())){
                throw new RuntimeException("Ya existe un pronostico con tales caracteristicas similares");
            }
        }
        this.pronosticos.add(pronostico);

    }

    private Persona obtenerPersona(String nombrePersona) {
        Persona persona = null;
        for(Persona p : this.personas){
            if(p.getNombre().equals(nombrePersona)){
                 persona = p;
            }
        }
        if(persona==null){
            persona = new Persona(nombrePersona);
            this.personas.add(persona);
        }
        return persona;
    }
}
