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

@ManagedBean(name = "invMovController")
@SessionScoped
public class InvMovController implements Serializable {

    @EJB
    private com.entities.InvMovFacade ejbFacade;
    @EJB
    private com.entities.UsuarioFacade usuarioFacade; 

    @EJB
    private com.entities.ProductoFacade productoFacade;    

    @EJB
    private com.ejb.SB_inventario sb_inventario;     
    
    private List<InvMov> items = null;
    private InvMov selected;
    private Date finicio;
    private Date ffinal;
    private Producto productoIdproducto;
    private int cantidad;
    private BigDecimal precio;   
    private Documento documento;    
    private List<InvDetm> detInvmov = new ArrayList<InvDetm>();
     

    public InvMovController() {
    }

    public List<InvDetm> getDetInvmov() {
        return detInvmov;
    }

    public void setDetInvmov(List<InvDetm> detInvmov) {
        this.detInvmov = detInvmov;
    }

    
    
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
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

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
    
    public InvMov getSelected() {
        return selected;
    }

    public void setSelected(InvMov selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InvMovFacade getFacade() {
        return ejbFacade;
    }

    public InvMov prepareCreate() {
        selected = new InvMov();
        selected.setFecha(new Date());
        Usuario usuario = usuarioFacade.find(1);
        
        selected.setUsuarioIdusuario(usuario);
        selected.setCantidad(0);        
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        
        selected.setInvDetmList(this.detInvmov);  
        if(sb_inventario.actulizaExistencia(selected).equals("ok")){
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InvMovCreated"));
        }else{
           JsfUtil.addErrorMessage("Surgio un error");
        }
         
        
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InvMovUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InvMovDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<InvMov> getItems() {
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

    public List<InvMov> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InvMov> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = InvMov.class)
    public static class InvMovControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InvMovController controller = (InvMovController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "invMovController");
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
            if (object instanceof InvMov) {
                InvMov o = (InvMov) object;
                return getStringKey(o.getIdinvMov());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InvMov.class.getName()});
                return null;
            }
        }

    }
    public void limpiar(){
        selected= null;
        this.detInvmov =  new ArrayList<InvDetm>();
        this.cantidad =0;
        //this.precio = new BigDecimal("0");*/
    }       
    
    
    public void addDetalle(){
        
       int id= 1;
       if(detInvmov!= null){
       id= detInvmov.size()+1;
       }
       
        InvDetm detalle = new InvDetm();
        detalle.setIdinvDetm(id);
        detalle.setInvMovIdinvMov(selected);
        detalle.setCantidad(cantidad);
        System.out.println("aqui-2");
        //detalle.setTotal(precio.multiply(new BigDecimal(cantidad)));
        
        detalle.setProductoIdproducto(productoIdproducto);
        System.out.println("aqui-3");
        selected.setCantidad(selected.getCantidad()+cantidad);
        
        this.detInvmov.add(detalle);
        
    }     
    
    public void buscar(){
    items = this.ejbFacade.findByDocumentoFecha(finicio, ffinal, documento);
    }    
   
   public void selecionar(){
        if(selected.getInvDetmList() !=null){
            this.detInvmov = selected.getInvDetmList();
        }
    
    }     

}
