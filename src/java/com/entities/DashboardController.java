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
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
/**
 *
 * @author mmixco
 */

@ManagedBean(name = "dashboardController")
@SessionScoped
public class DashboardController implements Serializable {
    
   @EJB
   private FacturaFacade facturaFacade;    
   private LineChartModel lineModel1;
   private BigDecimal maxLine;      
    
    private BarChartModel barModel;
 
    public DashboardController() {
    }
    
  @PostConstruct
    public void init() {
        //createLineModels();
         createBarModels();
    }
    
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
    
  public BarChartModel getBarModel() {
        return barModel;
    }
  
 private BarChartModel initBarModel() {
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
 
    private void createBarModels() {
        createBarModel();
     
    }
     
  private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Comparativo Ventas");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas");
        yAxis.setMin(0);
        yAxis.setMax(maxLine);
    }     
 
    private void createLineModels() {
      lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);     
         
        
    } 
    
  private LineChartModel initLinearModel() {
      
        maxLine = new BigDecimal("1");   
        LineChartModel model = new LineChartModel();
            
        
        LineChartSeries series1 = new LineChartSeries();
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
                   series1.set( "2016",valor );                    
               }       
                
         }  
       
        
 
      
 
        LineChartSeries series2 = new LineChartSeries();
      
        
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
                    series2.set(  "2016",valor );  
                    System.out.println("mes:"+element[0].toString()+" valor:"+valor);
               }       
                
         }  
               
 
      
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }    
    
 
}
