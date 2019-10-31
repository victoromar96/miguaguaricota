/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.principal;

import com.mycompany.entity.Producto;
import com.mycompany.session.ProductoJpaController;
import java.math.BigDecimal;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aplicaciones D
 */
public class main {

    public static void main(String[] args) {
        //llamar mi intancia de la cadena de conexion "copio el nombre de la persistencia"
        EntityManagerFactory enty = Persistence.createEntityManagerFactory("laboratorio");
        
        //clase controladora 
        ProductoJpaController pd = new ProductoJpaController(enty);
        
        //objeto 
        
        Producto prd = new Producto();
        //seteamos
        prd.setNombre("mantequilla");
        prd.setPrecio(BigDecimal.valueOf(13.87));
        
        //la funcion que esta dentro del controlador 
        pd.create(prd);
        
        //para arreglar el error de la zona horario 
        //?serverTimezone=UTC
        
        
    }
    
}
