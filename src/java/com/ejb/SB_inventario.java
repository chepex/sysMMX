/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;


import com.entities.Bodega;
import com.entities.Compra;
import com.entities.CompraDet;
import com.entities.Documento;

import com.entities.InvDetm;
import com.entities.InvMov;
import com.entities.Usuario;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mmixco
 */
@Stateless
public class SB_inventario {
    
    @EJB
    private com.entities.ProductoFacade productoFacade;     
    @EJB
    private com.entities.InvMovFacade invMovFacade;      
    

   public String actulizaExistencia(InvMov inv){
       
        for(InvDetm d : inv.getInvDetmList()){
            int existencia = d.getProductoIdproducto().getExistencia();
            int cantidadMovimiento = d.getCantidad();
            
            if(inv.getDocumentoIddocumento().getSumaResta().equals("S")){
                d.getProductoIdproducto().setExistencia(existencia+cantidadMovimiento);
            }
            if(inv.getDocumentoIddocumento().getSumaResta().equals("R")){
                d.getProductoIdproducto().setExistencia(existencia-cantidadMovimiento);
            
            } 
            productoFacade.edit(d.getProductoIdproducto());        
            
            
        }
       
       return "ok";
   
   }
   
   public String ingresoCompra(Compra compra){
       
        List<InvDetm> detInv = new ArrayList<InvDetm>(); 
        
        InvMov inv = new InvMov(1);
        inv.setFecha(new Date());
        inv.setBodegaIdbodega(new Bodega(1));
        inv.setDocumentoIddocumento(new Documento(1));
        inv.setNumReferencia(compra.getDocumento() );
        inv.setUsuarioIdusuario(new Usuario(1));
        
        
        for(CompraDet d:compra.getCompraDetList()){
             InvDetm invd = new InvDetm(1);
             invd.setCantidad(d.getCantidad());
             invd.setInvMovIdinvMov(inv);
             invd.setProductoIdproducto(d.getProductoIdproducto());
             detInv.add(invd);
        }
        inv.setInvDetmList(detInv);
        actulizaExistencia( inv);
        
        invMovFacade.edit(inv);
       
        return "ok";
   }

}
