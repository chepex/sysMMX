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
@Table(name = "tipo_transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t"),
    @NamedQuery(name = "TipoTransaccion.findByIdtipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.idtipoTransaccion = :idtipoTransaccion"),
    @NamedQuery(name = "TipoTransaccion.findByNombre", query = "SELECT t FROM TipoTransaccion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoTransaccion.findBySumaResta", query = "SELECT t FROM TipoTransaccion t WHERE t.sumaResta = :sumaResta"),
    @NamedQuery(name = "TipoTransaccion.findByActivo", query = "SELECT t FROM TipoTransaccion t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoTransaccion.findByUsuarioCreate", query = "SELECT t FROM TipoTransaccion t WHERE t.usuarioCreate = :usuarioCreate"),
    @NamedQuery(name = "TipoTransaccion.findByFechaCreate", query = "SELECT t FROM TipoTransaccion t WHERE t.fechaCreate = :fechaCreate"),
    @NamedQuery(name = "TipoTransaccion.findByUsuarioUpdate", query = "SELECT t FROM TipoTransaccion t WHERE t.usuarioUpdate = :usuarioUpdate"),
    @NamedQuery(name = "TipoTransaccion.findByFechaUpdate", query = "SELECT t FROM TipoTransaccion t WHERE t.fechaUpdate = :fechaUpdate")})
public class TipoTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_transaccion")
    private Integer idtipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "suma_Resta")
    private String sumaResta;
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

    public TipoTransaccion() {
    }

    public TipoTransaccion(Integer idtipoTransaccion) {
        this.idtipoTransaccion = idtipoTransaccion;
    }

    public TipoTransaccion(Integer idtipoTransaccion, String nombre, String sumaResta, boolean activo) {
        this.idtipoTransaccion = idtipoTransaccion;
        this.nombre = nombre;
        this.sumaResta = sumaResta;
        this.activo = activo;
    }

    public Integer getIdtipoTransaccion() {
        return idtipoTransaccion;
    }

    public void setIdtipoTransaccion(Integer idtipoTransaccion) {
        this.idtipoTransaccion = idtipoTransaccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSumaResta() {
        return sumaResta;
    }

    public void setSumaResta(String sumaResta) {
        this.sumaResta = sumaResta;
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
        hash += (idtipoTransaccion != null ? idtipoTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.idtipoTransaccion == null && other.idtipoTransaccion != null) || (this.idtipoTransaccion != null && !this.idtipoTransaccion.equals(other.idtipoTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.TipoTransaccion[ idtipoTransaccion=" + idtipoTransaccion + " ]";
    }
    
}
