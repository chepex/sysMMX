/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;


import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import org.primefaces.model.chart.ChartSeries;

 
/**
 *
 * @author mmixco
 */

@ManagedBean(name = "dashboardController")
@SessionScoped
public class DashboardController implements Serializable {
    
   @EJB
   private FacturaFacade facturaFacade; 
   @EJB
   private CompraFacade compraFacade;       
   private BigDecimal maxLine;          
   private BarChartModel ventaModel;
   private BarChartModel compraModel;   
 
    public DashboardController() {
    }
    
  @PostConstruct
    public void init() {
        //createLineModels();
         createBarModels();
         
    }

    public BarChartModel getVentaModel() {
        return ventaModel;
    }

    public BarChartModel getCompraModel() {
        return compraModel;
    }
    
    
    
    

  
    private BarChartModel initBarVenta() {
        BarChartModel model = new BarChartModel();
        maxLine = new BigDecimal("1");          
        ChartSeries series1 = new ChartSeries();
        Calendar cal = Calendar.getInstance();       
        Date date1 = cal.getTime();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy");        
        series1.setLabel(formateador.format(date1));           
        List<Object[]> lv = this.facturaFacade.ventaActual();
        if(!lv.isEmpty()){
            Iterator<Object[]>itr = lv.iterator();  
            while(itr.hasNext()) {
               Object[] element = itr.next();            
               BigDecimal valor =new BigDecimal( element[1].toString());
               if(valor.compareTo(maxLine)==1){
                maxLine = valor;
               }                
                System.out.println("mes:"+element[0].toString()+" valor:"+valor);
               series1.set( element[0].toString(),valor );                    
           }               
        }      
        
        ChartSeries series2 = new ChartSeries();       
        Calendar cal2 = Calendar.getInstance(); 
        cal2.add(Calendar.DATE, -365);
        Date date2 = cal2.getTime(); 
        series2.setLabel(formateador.format(date2));          
        List<Object[]> lv2 = this.facturaFacade.ventaAnterior();
        if(!lv2.isEmpty()){
            Iterator<Object[]>itr = lv2.iterator();  
            while(itr.hasNext()) {
               Object[] element = itr.next();            
               BigDecimal valor =new BigDecimal( element[1].toString());
               if(valor.compareTo(maxLine)==1){
                maxLine = valor;
               }                
                series2.set( element[0].toString(),valor );  
                System.out.println("mes:"+element[0].toString()+" valor:"+valor);
            }                     
        }  
        model.addSeries(series1);
        model.addSeries(series2);         
        return model;
    }
    
    private BarChartModel initBarCompra() {
        BarChartModel model = new BarChartModel();
        maxLine = new BigDecimal("1");          
        ChartSeries series1 = new ChartSeries();
        Calendar cal = Calendar.getInstance();       
        Date date1 = cal.getTime();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy");        
        series1.setLabel(formateador.format(date1));           
        List<Object[]> lv = this.compraFacade.compraActual();
        if(!lv.isEmpty()){
            Iterator<Object[]>itr = lv.iterator();  
            while(itr.hasNext()) {
               Object[] element = itr.next();            
               BigDecimal valor =new BigDecimal( element[1].toString());
               if(valor.compareTo(maxLine)==1){
                maxLine = valor;
               }                
                System.out.println("mes:"+element[0].toString()+" valor:"+valor);
               series1.set( element[0].toString(),valor );                    
           }               
        }      
        
        ChartSeries series2 = new ChartSeries();       
        Calendar cal2 = Calendar.getInstance(); 
        cal2.add(Calendar.DATE, -365);
        Date date2 = cal2.getTime(); 
        series2.setLabel(formateador.format(date2));          
        List<Object[]> lv2 = this.compraFacade.compraAnterior();
        if(!lv2.isEmpty()){
            Iterator<Object[]>itr = lv2.iterator();  
            while(itr.hasNext()) {
               Object[] element = itr.next();            
               BigDecimal valor =new BigDecimal( element[1].toString());
               if(valor.compareTo(maxLine)==1){
                maxLine = valor;
               }                
                series2.set( element[0].toString(),valor );  
                System.out.println("mes:"+element[0].toString()+" valor:"+valor);
            }                     
        }  
        model.addSeries(series1);
        model.addSeries(series2);         
        return model;
    }    
 
    private void createBarModels() {
        createBarVenta();    
        createBarCompra();
    }
     
    private void createBarVenta() {
        this.ventaModel = initBarVenta();         
        ventaModel.setTitle("Comparativo Ventas");
        ventaModel.setLegendPosition("ne");         
        Axis xAxis = ventaModel.getAxis(AxisType.X);         
        Axis yAxis = ventaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas");
        yAxis.setMin(0);
        yAxis.setMax(maxLine.add(new BigDecimal("10")));
    }  
    
    private void createBarCompra() {
        this.compraModel = initBarCompra();         
        compraModel.setTitle("Comparativo Compras");
        compraModel.setLegendPosition("ne");         
        Axis xAxis = compraModel.getAxis(AxisType.X);         
        Axis yAxis = compraModel.getAxis(AxisType.Y);
        yAxis.setLabel("Compra");
        yAxis.setMin(0);
        yAxis.setMax(maxLine.add(new BigDecimal("10")));
    }     
 
  
    
   
    
 
}
