/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.facades;

import com.quiz.entities.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author seanv
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "QuizPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public List<Persona> consultarPersonas() {
        List<Persona> persona = null;
        try {
            TypedQuery<Persona> query = em.createNamedQuery("Persona.findAll", Persona.class);
            persona = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return persona;
    }

    public Persona validate(String user, String password) {
        Persona persona = null;
        try {
            TypedQuery<Persona> query = em.createNamedQuery("Persona.login", Persona.class);
            query.setParameter("correo", user);
            query.setParameter("psw", password);
            persona = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return persona;
    }
    
}
