/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Experiencialaboral;
import facade.ExperiencialaboralFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Alberto Cazorla Suarez, Loubna Channouf Cherradi
 */
@Named(value = "modificarCrearExperienciaLaboralBean")
@RequestScoped
public class ModificarCrearExperienciaLaboralBean {

    @EJB
    private ExperiencialaboralFacade experiencialaboralFacade;
  
    @Inject PerfilBean perfilBean;
    
    Experiencialaboral experienciaLaboral;
    
    public ModificarCrearExperienciaLaboralBean() {
    }
    
    @PostConstruct
    public void init()
    {
        if(this.perfilBean.getExperienciaLaboralSeleccionada() == null){
            this.experienciaLaboral = new Experiencialaboral();
        }else{
            this.experienciaLaboral = perfilBean.experienciaLaboralSeleccionada;
        } 
    }

    public Experiencialaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(Experiencialaboral experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }
    
    public String doGuardarExperienciaLaboral(){
        experienciaLaboral.setExpLaboralUsuarioFK(perfilBean.getUsuarioSeleccionado());
        if(experienciaLaboral == null){
            this.experiencialaboralFacade.create(experienciaLaboral);
        }else{
            this.experiencialaboralFacade.edit(experienciaLaboral);
        }
        this.perfilBean.init();
        return "perfil";
    }
}
