package org.example;

import org.example.utilidades.LectorBD;
import org.example.utilidades.LectorCSV;

public class Main {
    public static void main(String[] args) {

        LectorCSV lectorCSV = new LectorCSV();
        lectorCSV.imprimirResultados();

        LectorBD lectorBD = new LectorBD();
        lectorBD.imprimirPronosticos();

    }
}