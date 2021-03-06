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
import javax.persistence.TypedQuery;

/**
 *
 * @author mmixco
 */
@Stateless
public class TipoPagoFacade extends AbstractFacade<TipoPago> {
    @PersistenceContext(unitName = "sysMMXPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPagoFacade() {
        super(TipoPago.class);
    }
    
    
    @Override
    public List<TipoPago> findAll() {
        TypedQuery<TipoPago> q = null;         
             q = em.createNamedQuery("TipoPago.findByActivo",TipoPago.class) ;   
        return q.getResultList();
    }      
    
}
