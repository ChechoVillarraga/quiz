/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controllers;

import com.quiz.entities.Correo;
import com.quiz.entities.Persona;
import com.quiz.facades.CorreoFacade;
import com.quiz.facades.PersonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author seanv
 */
@Named(value = "enviarController")
@SessionScoped
public class enviarController implements Serializable {

    private Correo correo;
    private Persona persona;
    @EJB
    private CorreoFacade correoFacade;
    @EJB
    private PersonaFacade personaFacade;

    public PersonaFacade getPersonaFacade() {
        return personaFacade;
    }

    public void setPersonaFacade(PersonaFacade personaFacade) {
        this.personaFacade = personaFacade;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

    /**
     * Creates a new instance of enviarController
     */
    public enviarController() {
    }

    public CorreoFacade getCorreoFacade() {
        return correoFacade;
    }

    public void setCorreoFacade(CorreoFacade correoFacade) {
        this.correoFacade = correoFacade;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public void enviarCorreo() {
        try {

            correoFacade.create(correo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error en envio de datos");
        }
    }

}
