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
 * @author Alberto Cazorla Suarez
 */
@Named(value = "modificarExperienciaLaboralBean")
@RequestScoped
public class ModificarExperienciaLaboralBean {

    @EJB
    private ExperiencialaboralFacade experiencialaboralFacade;
  
    @Inject PerfilBean perfilBean;
    
    Experiencialaboral experienciaLaboral;
    
    public ModificarExperienciaLaboralBean() {
    }
    
    @PostConstruct
    public void init()
    {
      this.experienciaLaboral = perfilBean.experienciaLaboralSeleccionada;  
    }

    public Experiencialaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(Experiencialaboral experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }
    
    public String doGuardarExperienciaLaboral(){
        this.experiencialaboralFacade.edit(experienciaLaboral);
        return "perfil";
    }
}
