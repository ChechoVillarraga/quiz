package com.quiz.controllers;

import com.quiz.controllers.util.JsfUtil;
import com.quiz.entities.Persona;
import com.quiz.entities.Rol;
import com.quiz.facades.RolFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@Named(value = "rolController")
@ViewScoped
public class RolController extends AbstractController<Rol> {

    @EJB
    private RolFacade rolFacade;
    private Rol rol;

    public RolController() {
        // Inform the Abstract parent controller of the concrete Rol Entity
        super(Rol.class);
    }

    @PostConstruct
    public void init() {
        rol = new Rol();
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from Rol?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", this.getSelected().getPersonaList());
        }
        return "/protegido/admin/crud/pages/persona/index";
    }

    public List<Rol> getItemsAvailableSelectOne() {
        return rolFacade.findAll();
    }

}
