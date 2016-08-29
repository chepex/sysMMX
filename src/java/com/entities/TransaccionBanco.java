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
@Table(name = "transaccion_banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionBanco.findAll", query = "SELECT t FROM TransaccionBanco t"),
    @NamedQuery(name = "TransaccionBanco.findByIdtransaccionBanco", query = "SELECT t FROM TransaccionBanco t WHERE t.idtransaccionBanco = :idtransaccionBanco"),
    @NamedQuery(name = "TransaccionBanco.findByIdcuenta", query = "SELECT t FROM TransaccionBanco t WHERE t.idcuenta = :idcuenta"),
    @NamedQuery(name = "TransaccionBanco.findByIdtipoTransaccion", query = "SELECT t FROM TransaccionBanco t WHERE t.idtipoTransaccion = :idtipoTransaccion"),
    @NamedQuery(name = "TransaccionBanco.findByFecha", query = "SELECT t FROM TransaccionBanco t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TransaccionBanco.findByValor", query = "SELECT t FROM TransaccionBanco t WHERE t.valor = :valor"),
    @NamedQuery(name = "TransaccionBanco.findByDescripcion", query = "SELECT t FROM TransaccionBanco t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TransaccionBanco.findByReferencia", query = "SELECT t FROM TransaccionBanco t WHERE t.referencia = :referencia"),
    @NamedQuery(name = "TransaccionBanco.findByUsuarioCreate", query = "SELECT t FROM TransaccionBanco t WHERE t.usuarioCreate = :usuarioCreate"),
    @NamedQuery(name = "TransaccionBanco.findByFechaCreate", query = "SELECT t FROM TransaccionBanco t WHERE t.fechaCreate = :fechaCreate"),
    @NamedQuery(name = "TransaccionBanco.findByUsuarioUpdate", query = "SELECT t FROM TransaccionBanco t WHERE t.usuarioUpdate = :usuarioUpdate"),
    @NamedQuery(name = "TransaccionBanco.findByFechaUpdate", query = "SELECT t FROM TransaccionBanco t WHERE t.fechaUpdate = :fechaUpdate")})
public class TransaccionBanco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtransaccion_banco")
    private Integer idtransaccionBanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuenta")
    private int idcuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo_transaccion")
    private int idtipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 80)
    @Column(name = "referencia")
    private String referencia;
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

    public TransaccionBanco() {
    }

    public TransaccionBanco(Integer idtransaccionBanco) {
        this.idtransaccionBanco = idtransaccionBanco;
    }

    public TransaccionBanco(Integer idtransaccionBanco, int idcuenta, int idtipoTransaccion, Date fecha, BigDecimal valor, String descripcion) {
        this.idtransaccionBanco = idtransaccionBanco;
        this.idcuenta = idcuenta;
        this.idtipoTransaccion = idtipoTransaccion;
        this.fecha = fecha;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Integer getIdtransaccionBanco() {
        return idtransaccionBanco;
    }

    public void setIdtransaccionBanco(Integer idtransaccionBanco) {
        this.idtransaccionBanco = idtransaccionBanco;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public int getIdtipoTransaccion() {
        return idtipoTransaccion;
    }

    public void setIdtipoTransaccion(int idtipoTransaccion) {
        this.idtipoTransaccion = idtipoTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
        hash += (idtransaccionBanco != null ? idtransaccionBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionBanco)) {
            return false;
        }
        TransaccionBanco other = (TransaccionBanco) object;
        if ((this.idtransaccionBanco == null && other.idtransaccionBanco != null) || (this.idtransaccionBanco != null && !this.idtransaccionBanco.equals(other.idtransaccionBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.TransaccionBanco[ idtransaccionBanco=" + idtransaccionBanco + " ]";
    }
    
}
