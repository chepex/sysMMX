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
@Table(name = "correlativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correlativo.findAll", query = "SELECT c FROM Correlativo c"),
    @NamedQuery(name = "Correlativo.findByIdcorrelativo", query = "SELECT c FROM Correlativo c WHERE c.idcorrelativo = :idcorrelativo"),
    @NamedQuery(name = "Correlativo.findByNombre", query = "SELECT c FROM Correlativo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Correlativo.findByPrefijo", query = "SELECT c FROM Correlativo c WHERE c.prefijo = :prefijo"),
    @NamedQuery(name = "Correlativo.findByValorActual", query = "SELECT c FROM Correlativo c WHERE c.valorActual = :valorActual"),
    @NamedQuery(name = "Correlativo.findByValorInicial", query = "SELECT c FROM Correlativo c WHERE c.valorInicial = :valorInicial"),
    @NamedQuery(name = "Correlativo.findByValorFinal", query = "SELECT c FROM Correlativo c WHERE c.valorFinal = :valorFinal"),
    @NamedQuery(name = "Correlativo.findByFecha", query = "SELECT c FROM Correlativo c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Correlativo.findByActivo", query = "SELECT c FROM Correlativo c WHERE c.activo = :activo")})
public class Correlativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcorrelativo")
    private Integer idcorrelativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prefijo")
    private String prefijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_actual")
    private int valorActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_inicial")
    private int valorInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_final")
    private int valorFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "usuario_create")
    private String usuarioCreate;
    @Size(max = 45)    
    @Column(name = "usuario_update")
    private String usuarioUpdate;
    @Size(max = 45)    
    @Column(name = "fecha_create")
    @Temporal(TemporalType.DATE)
    private Date fechaCreate;  
    @Column(name = "fecha_update")
    @Temporal(TemporalType.DATE)
    private Date fechaUpdate;      

    public Correlativo() {
    }

    public String getUsuarioCreate() {
        return usuarioCreate;
    }

    public void setUsuarioCreate(String usuarioCreate) {
        this.usuarioCreate = usuarioCreate;
    }

    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
    }

    public Date getFechaCreate() {
        return fechaCreate;
    }

    public void setFechaCreate(Date fechaCreate) {
        this.fechaCreate = fechaCreate;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    
    public Correlativo(Integer idcorrelativo) {
        this.idcorrelativo = idcorrelativo;
    }

    public Correlativo(Integer idcorrelativo, String nombre, String prefijo, int valorActual, int valorInicial, int valorFinal, Date fecha) {
        this.idcorrelativo = idcorrelativo;
        this.nombre = nombre;
        this.prefijo = prefijo;
        this.valorActual = valorActual;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.fecha = fecha;
    }

    public Integer getIdcorrelativo() {
        return idcorrelativo;
    }

    public void setIdcorrelativo(Integer idcorrelativo) {
        this.idcorrelativo = idcorrelativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(int valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcorrelativo != null ? idcorrelativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correlativo)) {
            return false;
        }
        Correlativo other = (Correlativo) object;
        if ((this.idcorrelativo == null && other.idcorrelativo != null) || (this.idcorrelativo != null && !this.idcorrelativo.equals(other.idcorrelativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Correlativo[ idcorrelativo=" + idcorrelativo + " ]";
    }
    
}
