/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controllers;

import com.quiz.entities.Persona;
import com.quiz.entities.Rol;
import com.quiz.facades.PersonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author seanv
 */
@Named(value = "loginController")
@SessionScoped
public class loginController implements Serializable {

    private Rol rolSeleccionado;
    private String pwd;
    private String msg;
    private String user;
    private Persona usuario;

    @Inject
    private PersonaFacade perFacade;

    /**
     * Creates a new instance of loginController
     */
    public loginController() {
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public PersonaFacade getPerFacade() {
        return perFacade;
    }

    public void setPerFacade(PersonaFacade perFacade) {
        this.perFacade = perFacade;
    }
    
    

    public String validateUsernamePassword() {
        String url = "";
        Persona per = perFacade.validate(user, pwd);
        if (per != null) {
            usuario = per;
            rolSeleccionado = usuario.getRolIdrol();
            int rolCompare = rolSeleccionado.getIdrol();
            if (rolCompare == 1) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                url = "protegido/admin/index?faces-redirect=true";
            } else if (rolCompare == 2) {
                usuario = per;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                url = "protegido/user/index?faces-redirect=true";
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correo o Contraseña incorrectos. Por favor verifique"));
            url = "login";
        }
        return url;
    }
}
