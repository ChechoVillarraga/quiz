/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c"),
    @NamedQuery(name = "Correo.findByIdcorreo", query = "SELECT c FROM Correo c WHERE c.idcorreo = :idcorreo"),
    @NamedQuery(name = "Correo.findByAsunto", query = "SELECT c FROM Correo c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "Correo.findByMensaje", query = "SELECT c FROM Correo c WHERE c.mensaje = :mensaje"),
    @NamedQuery(name = "Correo.findByFechaEnvio", query = "SELECT c FROM Correo c WHERE c.fechaEnvio = :fechaEnvio")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcorreo")
    private Integer idcorreo;
    @Size(max = 100)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 200)
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fechaEnvio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @JoinTable(name = "correopersona", joinColumns = {
        @JoinColumn(name = "correo_idcorreo", referencedColumnName = "idcorreo")}, inverseJoinColumns = {
        @JoinColumn(name = "persona_cedula", referencedColumnName = "cedula")})
    @ManyToMany
    private List<Persona> personaList;
    @JoinTable(name = "estadocorreo", joinColumns = {
        @JoinColumn(name = "correo_idcorreo", referencedColumnName = "idcorreo")}, inverseJoinColumns = {
        @JoinColumn(name = "estado_idestado", referencedColumnName = "idestado")})
    @ManyToMany
    private List<Estado> estadoList;

    public Correo() {
    }

    public Correo(Integer idcorreo) {
        this.idcorreo = idcorreo;
    }

    public Integer getIdcorreo() {
        return idcorreo;
    }

    public void setIdcorreo(Integer idcorreo) {
        this.idcorreo = idcorreo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcorreo != null ? idcorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.idcorreo == null && other.idcorreo != null) || (this.idcorreo != null && !this.idcorreo.equals(other.idcorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.quiz.entities.Correo[ idcorreo=" + idcorreo + " ]";
    }
    
}
