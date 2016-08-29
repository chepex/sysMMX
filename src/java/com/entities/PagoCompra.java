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
@Table(name = "pago_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoCompra.findAll", query = "SELECT p FROM PagoCompra p"),
    @NamedQuery(name = "PagoCompra.findByIdpagoCompra", query = "SELECT p FROM PagoCompra p WHERE p.idpagoCompra = :idpagoCompra"),
    @NamedQuery(name = "PagoCompra.findByIdcompra", query = "SELECT p FROM PagoCompra p WHERE p.idcompra = :idcompra"),
    @NamedQuery(name = "PagoCompra.findByIdbanco", query = "SELECT p FROM PagoCompra p WHERE p.idbanco = :idbanco"),
    @NamedQuery(name = "PagoCompra.findByIdcuenta", query = "SELECT p FROM PagoCompra p WHERE p.idcuenta = :idcuenta"),
    @NamedQuery(name = "PagoCompra.findByValor", query = "SELECT p FROM PagoCompra p WHERE p.valor = :valor"),
    @NamedQuery(name = "PagoCompra.findByFecha", query = "SELECT p FROM PagoCompra p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PagoCompra.findByUsuarioCreate", query = "SELECT p FROM PagoCompra p WHERE p.usuarioCreate = :usuarioCreate"),
    @NamedQuery(name = "PagoCompra.findByFechaCreate", query = "SELECT p FROM PagoCompra p WHERE p.fechaCreate = :fechaCreate"),
    @NamedQuery(name = "PagoCompra.findByUsuarioUpdate", query = "SELECT p FROM PagoCompra p WHERE p.usuarioUpdate = :usuarioUpdate"),
    @NamedQuery(name = "PagoCompra.findByFechaUpdate", query = "SELECT p FROM PagoCompra p WHERE p.fechaUpdate = :fechaUpdate")})
public class PagoCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago_compra")
    private Integer idpagoCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcompra")
    private int idcompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbanco")
    private BigDecimal idbanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuenta")
    private int idcuenta;
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

    public PagoCompra() {
    }

    public PagoCompra(Integer idpagoCompra) {
        this.idpagoCompra = idpagoCompra;
    }

    public PagoCompra(Integer idpagoCompra, int idcompra, BigDecimal idbanco, int idcuenta, BigDecimal valor, Date fecha) {
        this.idpagoCompra = idpagoCompra;
        this.idcompra = idcompra;
        this.idbanco = idbanco;
        this.idcuenta = idcuenta;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Integer getIdpagoCompra() {
        return idpagoCompra;
    }

    public void setIdpagoCompra(Integer idpagoCompra) {
        this.idpagoCompra = idpagoCompra;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public BigDecimal getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(BigDecimal idbanco) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpagoCompra != null ? idpagoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoCompra)) {
            return false;
        }
        PagoCompra other = (PagoCompra) object;
        if ((this.idpagoCompra == null && other.idpagoCompra != null) || (this.idpagoCompra != null && !this.idpagoCompra.equals(other.idpagoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.PagoCompra[ idpagoCompra=" + idpagoCompra + " ]";
    }
    
}
