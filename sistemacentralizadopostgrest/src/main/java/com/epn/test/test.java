/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author Aplicaciones D
 */
public class test {
   
public static void main(String[] arms){
    test obj = new test();
    obj.insertar(2,"zanahoria",14.2);
    obj.insertar(3,"zanahoria",14.2);
    
    
   
}

 public Connection getConexion(){
        Connection conexion = null;
        //localhost es la conexion a mi maquina
        String servidor = "localhost";
        //puerto por defecto de la bdd postgres es 5432
        String puerto = "5432";
        //nombre de la base de datos
        String baseDatos = "supermercado1";
        //la conexion a la base de datos 
        String url = "jdbc:postgresql://"+servidor+":"+puerto+"/"+baseDatos;
        
        String usuario = "postgres";
        
        String clave = "admin";
        //excepcion de tipo checked que me oblique a capturar
        //la excepcion
        
        try{
            conexion = DriverManager.getConnection(url,usuario,clave);
        }catch(SQLException ex){
            Logger.getLogger(test.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return conexion;
                
    }
 
 
    public void insertar(int codigo,String nombre, double precio){
        Connection conexion = getConexion();
        String sql = "insert into producto values ("+ codigo + ","+ nombre + "," +precio +")";
        //el statement prepara la secuencia para ejecutarse
        try(Statement at = conexion.createStatement()){
            // executeUpdate es la ejecucion de la secuencia 
            at.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

  
}

