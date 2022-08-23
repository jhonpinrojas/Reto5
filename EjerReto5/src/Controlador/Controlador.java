/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.CuerpoDeAgua;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Modelo.CuerpoDeAgua;

/**
 *
 * @author ContaIPUC
 */
public class Controlador  {
     ArrayList<CuerpoDeAgua> objLista = new ArrayList<CuerpoDeAgua>();
    /*
 * CRUD producto
 * Resive: modelo CuerpoDeAgua
 * Retorna: Boolean
 */
   
 
    public boolean registrar(CuerpoDeAgua ObjModCuerpoAgua){
        
        PreparedStatement ps = null;
        Connection objConn = ConexionBD.conectar();
        String tipocuerpo=ObjModCuerpoAgua.getTipocuerpo();
          String tipoagua=ObjModCuerpoAgua.getTipoagua();
            String nombre=ObjModCuerpoAgua.getNombre();
              int id=ObjModCuerpoAgua.getId();
                String municipio=ObjModCuerpoAgua.getMunicipio();
                  Double irca = ObjModCuerpoAgua.getIrca();
       // String sql = "INSERT INTO Cuerposagua (Tipocuerpo,Tipoagua,Nombre,ID,Municipio,IRCA) VALUES (?,?,?,?,?,?)";
        
          try (// Connection conn = objConn.conectar();  
                  Statement stmt = objConn.createStatement()) {
             stmt.executeUpdate("INSERT INTO Cuerposagua (Tipocuerpo,Tipoagua,Nombre,ID,Municipio,IRCA) VALUES ("+ "'" + tipocuerpo + "'," + "'" + tipoagua + "'," + "'" + nombre + "'," + "'" + id + "'," + "'" + municipio + "'," + "'" + irca + "'" + ");");
            JOptionPane.showMessageDialog(null, "Registro exitoso");
          
  
          //  objConn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            try{
                objConn.close();
                System.out.println("Cerrar conexion registrar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return true;  
    }  

    public boolean modificar(CuerpoDeAgua ObjModCuerpoAgua){
        
        PreparedStatement ps = null;
        Connection objConn = ConexionBD.conectar();
         String tipocuerpo=ObjModCuerpoAgua.getTipocuerpo();
          String tipoagua=ObjModCuerpoAgua.getTipoagua();
            String nombre=ObjModCuerpoAgua.getNombre();
              int id=ObjModCuerpoAgua.getId();
                String municipio=ObjModCuerpoAgua.getMunicipio();
                  Double irca = ObjModCuerpoAgua.getIrca();
    
        try{
            Statement stmt = objConn.createStatement();
            stmt.executeUpdate("UPDATE Cuerposagua SET Nombre = '" + nombre + "', ID = '" + id + "', Municipio = '" + municipio + "', Tipoagua = '" + tipoagua + "', Tipocuerpo = '" + tipocuerpo + "', IRCA = '"+ irca + "' WHERE ID = '" + id + "';");
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            System.out.println("error de datos");
            return false;
        }finally{
            try{
                objConn.close();
                System.out.println("Cerrar conexion modificar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  

    public void eliminar(int id){
        
        PreparedStatement ps = null;
        Connection objConn = ConexionBD.conectar();
            
        try{
            
            Statement stmt = objConn.createStatement();
            stmt.executeUpdate("DELETE FROM Cuerposagua WHERE id = '" + id + "';");
            JOptionPane.showMessageDialog(null, "Se eliminó el registro");
            
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                objConn.close();
                System.out.println("Cerrar conexion eliminar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  

    public CuerpoDeAgua buscar(CuerpoDeAgua ObjModCuerpoAgua){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection objConn = ConexionBD.conectar();
        
        String sql = "SELECT * FROM Cuerposagua WHERE ID = '" + ObjModCuerpoAgua.getId() + "'";
        CuerpoDeAgua ObjCuerpoAgua = new CuerpoDeAgua();
       
        try(Statement stmt = objConn.createStatement()){
             {
            ResultSet resultSet = stmt.executeQuery(sql);
           
            while(resultSet.next()){
                ObjModCuerpoAgua.setTipocuerpo(resultSet.getString("Tipocuerpo"));      
                ObjModCuerpoAgua.setTipoagua(resultSet.getString("Tipoagua"));
                ObjModCuerpoAgua.setNombre(resultSet.getString("Nombre"));
                ObjModCuerpoAgua.setId(Integer.valueOf(resultSet.getString("ID"))); 
                ObjModCuerpoAgua.setMunicipio(resultSet.getString("Municipio"));
                ObjModCuerpoAgua.setIrca(Double.valueOf(resultSet.getString("IRCA")));
                 JOptionPane.showMessageDialog(null, "Busqueda exitosa");
            }
             return ObjModCuerpoAgua;
           
        }

           
            
        }catch(SQLException e){
            System.err.println(e);
                JOptionPane.showMessageDialog(null, "ID incorrecto");
            //return false;
        }finally{
            try{
                objConn.close();
                System.out.println("Cerrar conexion buscar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return ObjModCuerpoAgua;
    }  
    
    public ArrayList<CuerpoDeAgua> consulta(){
        
       
        objLista.clear();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection objConn = ConexionBD.conectar();
        
        String sql = "SELECT * FROM Cuerposagua";
        
        try{
            
            ps = objConn.prepareStatement(sql);  
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                while(rs.next()){
                CuerpoDeAgua ObjModCuerpoAgua = new CuerpoDeAgua();
                ObjModCuerpoAgua.setId(rs.getInt("ID"));
		ObjModCuerpoAgua.setNombre(rs.getString("Nombre"));
                ObjModCuerpoAgua.setMunicipio(rs.getString("Municipio"));
                ObjModCuerpoAgua.setTipocuerpo(rs.getString("Tipocuerpo"));
                ObjModCuerpoAgua.setTipoagua(rs.getString("Tipoagua"));
                ObjModCuerpoAgua.setIrca(rs.getDouble("IRCA"));
		
                
                objLista.add(ObjModCuerpoAgua);
                    
                }
                
                System.out.println(objLista.size());
                return objLista;
            }

            return objLista;
            
        }catch(SQLException e){
            System.err.println(e);
            return objLista;
        }finally{
            try{
                objConn.close();
                System.out.println("Cerrar conexion consulta");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  
    
    public String Niveles(){
        String riesgo="";
        
        for (int i = 0; i < objLista.size(); i++) {
            riesgo += objLista.get(i).nivel() + "\n";
        }
        
      return riesgo;
    
    }
    
    public String MenorMedio(){
        String menores;
        int contador = 0;
        for (int i = 0; i < objLista.size(); i++) {
            if(objLista.get(i).getIrca() >= 0 && objLista.get(i).getIrca() <= 35){
                contador++;
            }
        
        }
        menores = contador + "\n";
        return menores;
    }
    
    public String Medio(){
        String medios ="NA";
        for (int i = 0; i < objLista.size(); i++) {
            if("MEDIO".equals(objLista.get(i).nivel())){
                medios += objLista.get(i).getNombre() + "\n";
            }
        }
        
        if(medios.length() > 2){
            medios = medios.replace("NA","");
        }else{
            medios += "\n";
        }
        
        return medios;
    }
    
   public String Menor(){ 
        String datos_menor="";
        double menor = objLista.get(0).getIrca();
        String nomb = objLista.get(0).getNombre();
        int cod = objLista.get(0).getId();
        for (int i = 0; i < objLista.size(); i++) {
             if (objLista.get(i).getIrca() < menor){
                 menor = objLista.get(i).getIrca();
                 nomb = objLista.get(i).getNombre();
                 cod = objLista.get(i).getId();
             }
        }
       datos_menor = nomb + " " + cod;  
       return datos_menor;
   }
    
    
  
}
