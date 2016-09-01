package com.quiz.controllers;

import com.quiz.controllers.util.JsfUtil;
import com.quiz.entities.Correo;
import com.quiz.entities.Persona;
import com.quiz.facades.PersonaFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import javax.inject.Named;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@Named(value = "correoController")
@ViewScoped
public class CorreoController extends AbstractController<Correo> {

    @EJB
    private PersonaFacade personaFacade;
    private Persona persona;

    public CorreoController() {
        // Inform the Abstract parent controller of the concrete Correo Entity
        super(Correo.class);
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from Correo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", this.getSelected().getPersonaList());
        }
        return "/protegido/admin/crud/pages/persona/index";
    }

    /**
     * Sets the "items" attribute with a collection of Estado entities that are
     * retrieved from Correo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Estado page
     */
    public String navigateEstadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Estado_items", this.getSelected().getEstadoList());
        }
        return "/protegido/admin/crud/pages/estado/index";
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(personaFacade.findAll(), true);
    }
}
