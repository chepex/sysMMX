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
public class CompraFacade extends AbstractFacade<Compra> {
    @PersistenceContext(unitName = "sysMMXPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraFacade() {
        super(Compra.class);
    }
    
    public List<Compra> findByOrdenId(Date fi, Date ff, Proveedor prov) {
        TypedQuery<Compra> q = null;
        System.out.println("fi-->"+fi);
        System.out.println("ff-->"+ff);
        System.out.println("prov-->"+prov);
        if(prov==null){
                 q = em.createNamedQuery("Compra.findByFecha",Compra.class)
                .setParameter("fi", fi)
                .setParameter("ff", ff);
        } 
        if(null!=fi && prov!=null){
             q = em.createNamedQuery("Compra.findByFechaProv",Compra.class)
                .setParameter("fi", fi)
                .setParameter("ff", ff)
                .setParameter("prov", prov.getIdproveedor());
        }        
        if(null==fi){
             q = em.createNamedQuery("Compra.findByProveedor",Compra.class)               
                .setParameter("prov", prov.getIdproveedor());
        }
       
        
        return q.getResultList();
    }    
    
}
