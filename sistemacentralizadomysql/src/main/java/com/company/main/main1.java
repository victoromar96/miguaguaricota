/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.session.ProductoJpaController;
import com.mycompany.entidades.Producto;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Aplicaciones D
 */
public class main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //toma los parametros establecidos de la cadena de conexion 
        EntityManagerFactory enty = Persistence.createEntityManagerFactory("practicabdd");
        
        //la clase controladora recibe de parametro una cadena de conexion 
        ProductoJpaController pdj = new ProductoJpaController(enty);
        
        Producto p = new Producto();
        p.setNombre("chocolate");
        Double d1 = 10.55;
        BigDecimal bdl = BigDecimal.valueOf(d1.doubleValue());
        p.setPrecio(bdl);
        
        //?serverTimezone=UTC
        try{
            pdj.create(p);
        }catch(Exception ex){
            Logger.getLogger(main1.class.getName()).log(Level.ALL.SEVERE,null,ex);
            
        }
        
        
    }
    
}
