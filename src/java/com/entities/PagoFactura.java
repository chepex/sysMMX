/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chepe
 */
@Entity
@Table(name = "pago_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoFactura.findAll", query = "SELECT p FROM PagoFactura p"),
    @NamedQuery(name = "PagoFactura.findByIdpagoFactura", query = "SELECT p FROM PagoFactura p WHERE p.idpagoFactura = :idpagoFactura"),
    @NamedQuery(name = "PagoFactura.findByIdfactura", query = "SELECT p FROM PagoFactura p WHERE p.idfactura = :idfactura"),
    @NamedQuery(name = "PagoFactura.findByIdbanco", query = "SELECT p FROM PagoFactura p WHERE p.idbanco = :idbanco"),
    @NamedQuery(name = "PagoFactura.findByIdcuenta", query = "SELECT p FROM PagoFactura p WHERE p.idcuenta = :idcuenta"),
    @NamedQuery(name = "PagoFactura.findByValor", query = "SELECT p FROM PagoFactura p WHERE p.valor = :valor"),
    @NamedQuery(name = "PagoFactura.findByFecha", query = "SELECT p FROM PagoFactura p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PagoFactura.findByUsuarioCreate", query = "SELECT p FROM PagoFactura p WHERE p.usuarioCreate = :usuarioCreate"),
    @NamedQuery(name = "PagoFactura.findByFechaCreate", query = "SELECT p FROM PagoFactura p WHERE p.fechaCreate = :fechaCreate"),
    @NamedQuery(name = "PagoFactura.findByUsuarioUpdate", query = "SELECT p FROM PagoFactura p WHERE p.usuarioUpdate = :usuarioUpdate"),
    @NamedQuery(name = "PagoFactura.findByFechaUpdate", query = "SELECT p FROM PagoFactura p WHERE p.fechaUpdate = :fechaUpdate"),
    @NamedQuery(name = "PagoFactura.findByPagoFacturacol", query = "SELECT p FROM PagoFactura p WHERE p.pagoFacturacol = :pagoFacturacol")})
public class PagoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago_factura")
    private Integer idpagoFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfactura")
    private int idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbanco")
    private int idbanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuenta")
    private int idcuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "usuario_create")
    private String usuarioCreate;
    @Column(name = "fecha_create")
    @Temporal(TemporalType.DATE)
    private Date fechaCreate;
    @Size(max = 45)
    @Column(name = "usuario_update")
    private String usuarioUpdate;
    @Column(name = "fecha_update")
    @Temporal(TemporalType.DATE)
    private Date fechaUpdate;
    @Size(max = 45)
    @Column(name = "pago_facturacol")
    private String pagoFacturacol;

    public PagoFactura() {
    }

    public PagoFactura(Integer idpagoFactura) {
        this.idpagoFactura = idpagoFactura;
    }

    public PagoFactura(Integer idpagoFactura, int idfactura, int idbanco, int idcuenta, BigDecimal valor, Date fecha) {
        this.idpagoFactura = idpagoFactura;
        this.idfactura = idfactura;
        this.idbanco = idbanco;
        this.idcuenta = idcuenta;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Integer getIdpagoFactura() {
        return idpagoFactura;
    }

    public void setIdpagoFactura(Integer idpagoFactura) {
        this.idpagoFactura = idpagoFactura;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(int idbanco) {
        this.idbanco = idbanco;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuarioCreate() {
        return usuarioCreate;
    }

    public void setUsuarioCreate(String usuarioCreate) {
        this.usuarioCreate = usuarioCreate;
    }

    public Date getFechaCreate() {
        return fechaCreate;
    }

    public void setFechaCreate(Date fechaCreate) {
        this.fechaCreate = fechaCreate;
    }

    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public String getPagoFacturacol() {
        return pagoFacturacol;
    }

    public void setPagoFacturacol(String pagoFacturacol) {
        this.pagoFacturacol = pagoFacturacol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpagoFactura != null ? idpagoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoFactura)) {
            return false;
        }
        PagoFactura other = (PagoFactura) object;
        if ((this.idpagoFactura == null && other.idpagoFactura != null) || (this.idpagoFactura != null && !this.idpagoFactura.equals(other.idpagoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.PagoFactura[ idpagoFactura=" + idpagoFactura + " ]";
    }
    
}
