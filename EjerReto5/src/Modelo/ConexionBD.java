/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jhon pinedo
 */
public class ConexionBD {
    static private String driver = "jdbc:sqlite:";
    static private String ruta = System.getProperty("user.dir");
    static private String bd = "Databasereto4.db";
    static private String url = driver + ruta + "/" + bd;
    static Connection conexion = null;
    
    public static Connection conectar(){
         
        
        try {
         conexion = DriverManager.getConnection(url);
            System.out.println("Conexion exitosa");
            return conexion;
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println("No se pudo conectar a la base de datos");
        }
       return conexion;
    }
    
     public static Connection getConexion(){
        conectar();
        return conexion;
    }
    
    public static void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexión");
            ex.printStackTrace();
        }
    }
    
}
