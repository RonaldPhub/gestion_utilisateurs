/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe Connexion représent la connectivité entre l'application et la base
 * de donnée
 *
 * @author r.pina
 */
public class Connexion {

//    private static String url = "jdbc:mysql://localhost:3306/ap4";
//    private static String user = "root";
//    private static String pass = "";
    private static String url = "jdbc:mysql://172.28.37.18:3306/ap4";
    private static String user = "rpina";
    private static String pass = "Marthin4889";

    private static Connection con = null;

    /**
     * Méthode qui sert à instancié la connexion vers la base de donnée
     */
    public static Connection getConnexion() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    //hello
}
