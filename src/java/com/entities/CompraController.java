package com.entities;

import com.entities.util.JsfUtil;
import com.entities.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "compraController")
@SessionScoped
public class CompraController implements Serializable {

    @EJB
    private com.entities.CompraFacade ejbFacade;
    @EJB
    private com.entities.CorrelativoFacade correlativoFacade;    
    @EJB
    private com.entities.UsuarioFacade usuarioFacade;    
    private List<Compra> items = null;
    private Compra selected;
    private Producto productoIdproducto;
    private int cantidad;
    private BigDecimal precio;
    private List<CompraDet> detCompra = new ArrayList<CompraDet>();
    private Proveedor proveedor;
    private Date finicio;
    private Date ffinal;
    
    

    public CompraController() {
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfinal() {
        return ffinal;
    }

    public void setFfinal(Date ffinal) {
        this.ffinal = ffinal;
    }
    
    

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    

    public List<CompraDet> getDetCompra() {
        return detCompra;
    }

    public void setDetCompra(List<CompraDet> detCompra) {
        this.detCompra = detCompra;
    }

    
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }
    
    

    public Compra getSelected() {
        return selected;
    }

    public void setSelected(Compra selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CompraFacade getFacade() {
        return ejbFacade;
    }

  
    
    public Compra prepareCreate() {
        
        selected = new Compra();
        selected.setFecha(new Date());
        Usuario usuario = usuarioFacade.find(1);
        
        selected.setUsuarioIdusuario(usuario);
        selected.setCantidad(0);
        selected.setTotal(new BigDecimal("0"));
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        List<Correlativo> lcort = correlativoFacade.findByNombre("Compra");
        if(!lcort.isEmpty()){
            Correlativo c= lcort.get(0);
            int nuevoValor= c.getValorActual()+1;
            String vcorrelativo = c.getPrefijo()+nuevoValor;
            c.setValorActual(nuevoValor);
            correlativoFacade.edit(c);
             selected.setDocumento(vcorrelativo);
        
        }else{
            selected.setDocumento("No corelt");
        }
        for(CompraDet d :detCompra){
            System.out.println("d"+d);
            System.out.println("cantidad"+d.getCantidad());
            System.out.println("precio"+d.getPrecio());
        }
       
        selected.setCompraDetList(detCompra);
         
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CompraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CompraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CompraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Compra> getItems() {
        /*if (items == null) {
            items = getFacade().findAll();
        }*/
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Compra> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Compra> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Compra.class)
    public static class CompraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompraController controller = (CompraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "compraController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Compra) {
                Compra o = (Compra) object;
                return getStringKey(o.getIdcompra());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Compra.class.getName()});
                return null;
            }
        }

    }
    
    public void addDetalle(){
        
       int id= 1;
       if(detCompra!= null){
       id= detCompra.size()+1;
       }
        
        CompraDet detalle = new CompraDet();
        detalle.setIdcompraDet(id);
        detalle.setCompraIdcompra(selected);
        detalle.setCantidad(cantidad);
        detalle.setPrecio(precio);
        detalle.setTotal(precio.multiply(new BigDecimal(cantidad)));
        
        detalle.setProductoIdproducto(productoIdproducto);
        
        selected.setCantidad(selected.getCantidad()+cantidad);
        selected.setTotal(selected.getTotal().add(precio.multiply(new BigDecimal(cantidad))));
        this.detCompra.add(detalle);
        
    }
    
    public void buscar(){
    items = this.ejbFacade.findByOrdenId(finicio, ffinal, proveedor);
    
    
    
    }
    
    public void selecionar(){
    
    this.detCompra = selected.getCompraDetList();
    }
    
    public void limpiar(){
        selected= null;
        this.detCompra =  new ArrayList<CompraDet>();
        this.cantidad =0;
        this.precio = new BigDecimal("0");
    }    

}
