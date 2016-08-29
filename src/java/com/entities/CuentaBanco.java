/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
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
@Table(name = "cuenta_banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaBanco.findAll", query = "SELECT c FROM CuentaBanco c"),
    @NamedQuery(name = "CuentaBanco.findByIdcuenta", query = "SELECT c FROM CuentaBanco c WHERE c.idcuenta = :idcuenta"),
    @NamedQuery(name = "CuentaBanco.findByIdbanco", query = "SELECT c FROM CuentaBanco c WHERE c.idbanco = :idbanco"),
    @NamedQuery(name = "CuentaBanco.findByNumero", query = "SELECT c FROM CuentaBanco c WHERE c.numero = :numero"),
    @NamedQuery(name = "CuentaBanco.findByActivo", query = "SELECT c FROM CuentaBanco c WHERE c.activo = :activo"),
    @NamedQuery(name = "CuentaBanco.findByUsuarioCreate", query = "SELECT c FROM CuentaBanco c WHERE c.usuarioCreate = :usuarioCreate"),
    @NamedQuery(name = "CuentaBanco.findByFechaCreate", query = "SELECT c FROM CuentaBanco c WHERE c.fechaCreate = :fechaCreate"),
    @NamedQuery(name = "CuentaBanco.findByUsuarioUpdate", query = "SELECT c FROM CuentaBanco c WHERE c.usuarioUpdate = :usuarioUpdate"),
    @NamedQuery(name = "CuentaBanco.findByFechaUpdate", query = "SELECT c FROM CuentaBanco c WHERE c.fechaUpdate = :fechaUpdate")})
public class CuentaBanco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuenta")
    private Integer idcuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbanco")
    private int idbanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
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

    public CuentaBanco() {
    }

    public CuentaBanco(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public CuentaBanco(Integer idcuenta, int idbanco, String numero, boolean activo) {
        this.idcuenta = idcuenta;
        this.idbanco = idbanco;
        this.numero = numero;
        this.activo = activo;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public int getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(int idbanco) {
        this.idbanco = idbanco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBanco)) {
            return false;
        }
        CuentaBanco other = (CuentaBanco) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.CuentaBanco[ idcuenta=" + idcuenta + " ]";
    }
    
}
