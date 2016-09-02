/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controllers;

import com.quiz.controllers.util.JsfUtil;
import com.quiz.entities.Persona;
import com.quiz.facades.PersonaFacade;
import com.quiz.facades.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author seanv
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private PersonaFacade personaFacade;
    private Persona persona;
    private RolFacade rolFacade;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @PostConstruct
    public void init() {
        persona = new Persona();
    }

    public void registrarCliente() {
        String lo ="";
        try {
            personaFacade.create(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Se ha actualizado correctamente el registro"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se pudo actualizar correctamente el registro"));
        }

    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(rolFacade.findAll(), false);
    }

}
