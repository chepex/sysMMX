/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author chepe
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {
    @PersistenceContext(unitName = "sysMMXPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
public List<Factura> findByClienteFecha(Date fi, Date ff, Cliente client) {
        TypedQuery<Factura> q = null;
         
  
        if(null!=fi && client!=null){
             q = em.createNamedQuery("Factura.findByDocumentoFecha",Factura.class)
                .setParameter("fi", fi)
                .setParameter("ff", ff)
                .setParameter("cliente", client.getIdcliente());
        }        
        if(null==fi &&  client!=null){
             q = em.createNamedQuery("Factura.findByIdcliente",Factura.class)               
                .setParameter("cliente",  client.getIdcliente());
        }
       
        
        return q.getResultList();
    }    
    
}
