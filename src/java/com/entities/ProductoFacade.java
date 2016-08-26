/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author chepe
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "sysMMXPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    public List<Producto> findByCategoria(Categoria cat) {
        TypedQuery<Producto> q = null;
         
             q = em.createNamedQuery("Producto.findByCategoria",Producto.class)               
                .setParameter("categoria", cat);
              
        return q.getResultList();
    } 
    
    @Override
    public List<Producto> findAll() {
        TypedQuery<Producto> q = null;         
             q = em.createNamedQuery("Producto.findByActivo",Producto.class) ;   
        return q.getResultList();
    }     

    
    public List<Object[]> existenciaCategoria(){
        Query q  = null;
        List<Object[]> lo = null;  
       
        String query="  select c.nombre, sum(existencia) from producto p, categoria c\n" +
                " where p.categoria_idcategoria = c.idcategoria\n" +
                " group by c.nombre";                             
        try{            
            q=  em.createNativeQuery(query);            
            lo= q.getResultList();
        }catch(Exception ex){
            lo= null;
            System.out.println("::::"+ex);
        }
            
       return lo;        
              
               
    }    
    
    
}
