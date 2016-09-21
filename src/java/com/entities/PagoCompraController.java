package com.entities;

import com.entities.util.JsfUtil;
import com.entities.util.JsfUtil.PersistAction;

import java.io.Serializable;
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

@ManagedBean(name = "pagoCompraController")
@SessionScoped
public class PagoCompraController implements Serializable {

    @EJB
    private com.entities.PagoCompraFacade ejbFacade;
    @EJB
    private com.entities.CompraFacade compraFacade;   
    @EJB
    private com.entities.CuentaBancoFacade cuentaBancoFacade;       
    @EJB
    private com.entities.ProveedorFacade proveedorFacade;           
    private List<PagoCompra> items = null;
    private List<Compra> lcompra = null;     
    private List<CuentaBanco> lcuentaBanco = null;       
    private PagoCompra selected;
    private Proveedor proveedor;
    private Compra selectedCompra;

    public PagoCompraController() {
    }

    public Compra getSelectedCompra() {
        return selectedCompra;
    }

    public void setSelectedCompra(Compra selectedCompra) {
        this.selectedCompra = selectedCompra;
    }

    
    
    public List<CuentaBanco> getLcuentaBanco() {
        return lcuentaBanco;
    }

    public void setLcuentaBanco(List<CuentaBanco> lcuentaBanco) {
        this.lcuentaBanco = lcuentaBanco;
    }


    
    
    public List<Compra> getLcompra() {
        return lcompra;
    }

    public void setLcompra(List<Compra> lcompra) {
        this.lcompra = lcompra;
    }

    
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
    public PagoCompra getSelected() {
        return selected;
    }

    public void setSelected(PagoCompra selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setIdpagoCompra(0);
    }

    private PagoCompraFacade getFacade() {
        return ejbFacade;
    }

    public PagoCompra prepareCreate() {
        selected = new PagoCompra();
        
        this.lcuentaBanco = null;
        initializeEmbeddableKey();
        return selected;
    }

    public String  create() {

        if(selected.getValor().compareTo(selectedCompra.getSaldo())==1 ){
            JsfUtil.addErrorMessage("El valor del abono es mayor al saldo de la factura, saldo:"+selectedCompra.getSaldo());
            return "error";
        }
        selectedCompra.setSaldo(selectedCompra.getSaldo().subtract(selected.getValor()));        
        selected.setCompraIdcompra(this.selectedCompra);
        selected.setFecha(new Date());
        selectedCompra.getProveedorIdproveedor().setSaldo(selectedCompra.getProveedorIdproveedor().getSaldo().subtract(selected.getValor()));
        compraFacade.edit(selectedCompra);
        proveedorFacade.edit(selectedCompra.getProveedorIdproveedor());
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PagoCompraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        consultaPagos();
        
        return "ok";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PagoCompraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PagoCompraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PagoCompra> getItems() {
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

    public List<PagoCompra> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PagoCompra> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PagoCompra.class)
    public static class PagoCompraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PagoCompraController controller = (PagoCompraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pagoCompraController");
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
            if (object instanceof PagoCompra) {
                PagoCompra o = (PagoCompra) object;
                return getStringKey(o.getIdpagoCompra());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PagoCompra.class.getName()});
                return null;
            }
        }

    }
    
    
    public void consultaPendiente(){
   
    lcompra = compraFacade.findByProveedorPendiente(this.proveedor);
        if(lcompra.isEmpty()){
         JsfUtil.addErrorMessage("No se encontraron facturas pendientes");
        }
   
    }    
    
    public void consultaCuenta(){
   
    lcuentaBanco = cuentaBancoFacade.findByIdbanco(this.selected.getBancoIdbanco());
        if(lcuentaBanco.isEmpty()){
         JsfUtil.addErrorMessage("No se encontraron cuentas asociados a ese banco");
        }
   
    }       
    
    public void consultaPagos(){
        if(selectedCompra!=null){
            items= this.ejbFacade.findByCompra(this.selectedCompra);
        }
        
    }

}
