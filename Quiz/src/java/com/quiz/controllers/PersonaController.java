package com.quiz.controllers;

import com.quiz.entities.Persona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    @Inject
    private RolController rolIdrolController;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona Entity
        super(Persona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        rolIdrolController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Correo entities that are
     * retrieved from Persona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Correo page
     */
    public String navigateCorreoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Correo_items", this.getSelected().getCorreoList());
        }
        return "/protegido/admin/crud/pages/correo/index";
    }

    /**
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRolIdrol(ActionEvent event) {
        if (this.getSelected() != null && rolIdrolController.getSelected() == null) {
            rolIdrolController.setSelected(this.getSelected().getRolIdrol());
        }
    }
}
