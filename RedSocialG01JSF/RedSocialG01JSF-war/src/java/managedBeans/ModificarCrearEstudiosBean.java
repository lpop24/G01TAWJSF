/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Estudios;
import facade.EstudiosFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Alberto Cazorla Suarez
 */
@Named(value = "modificarCrearEstudiosBean")
@RequestScoped


public class ModificarCrearEstudiosBean {

    @EJB
    private EstudiosFacade estudiosFacade;
   
    
    @Inject PerfilBean perfilBean;
    Estudios estudio;
    
    public ModificarCrearEstudiosBean() {
    }
    
    @PostConstruct
    public void init()
    {
      this.estudio = perfilBean.estudioSeleccionado;  
    }

    public Estudios getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudios estudio) {
        this.estudio = estudio;
    }
    
    public String doGuardarEstudio(){
        this.estudiosFacade.edit(estudio);
        return "perfil";
    }
    
    
    
}
