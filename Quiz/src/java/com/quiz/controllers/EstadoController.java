package com.quiz.controllers;

import com.quiz.entities.Estado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "estadoController")
@ViewScoped
public class EstadoController extends AbstractController<Estado> {

    public EstadoController() {
        // Inform the Abstract parent controller of the concrete Estado Entity
        super(Estado.class);
    }

    /**
     * Sets the "items" attribute with a collection of Correo entities that are
     * retrieved from Estado?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Correo page
     */
    public String navigateCorreoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Correo_items", this.getSelected().getCorreoList());
        }
        return "/protegido/admin/crud/pages/correo/index";
    }

}
