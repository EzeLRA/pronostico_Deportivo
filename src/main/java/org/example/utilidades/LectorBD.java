package org.example.utilidades;

import java.sql.*;

public class LectorBD {

    //47:25 Continuar con el codigo


    public void imprimirPronosticos(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pronosticos","root","eze_LRA842._.");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pronosticos");

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
