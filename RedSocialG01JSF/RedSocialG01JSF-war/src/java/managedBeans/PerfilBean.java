/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Estudios;
import java.util.Collection;
import entity.Experiencialaboral;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import facade.UsuarioFacade;
import entity.Usuario;
import facade.EstudiosFacade;
import facade.ExperiencialaboralFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Alberto Cazorla Suarez, Loubna Channouf Cherradi
 */
@Named(value = "perfilBean")
@RequestScoped
public class PerfilBean {

    @EJB
    private ExperiencialaboralFacade experiencialaboralFacade;

    @EJB
    private EstudiosFacade estudiosFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    @Inject LoginBean loginBean;
    
    protected Usuario usuarioSeleccionado;
    protected List <Experiencialaboral> listaExperiencialaboral;
    protected List <Estudios> listaEstudios;
    protected Estudios estudioSeleccionado;
    protected Experiencialaboral experienciaLaboralSeleccionada;
    
    
    public PerfilBean() {
    }

    @PostConstruct
    public void init() {
        this.usuarioSeleccionado = loginBean.getUsuarioSeleccionado();
        this.listaEstudios = this.estudiosFacade.findEstudios(usuarioSeleccionado.getIdUsuario());
        //this.listaEstudios = (List<Estudios>) this.usuarioSeleccionado.getEstudiosCollection();
        this.listaExperiencialaboral = this.experiencialaboralFacade.findExpLaboral(usuarioSeleccionado.getIdUsuario());
        //this.listaExperiencialaboral = (List<Experiencialaboral>) this.usuarioSeleccionado.getExperiencialaboralCollection();
    }
    
    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public List<Experiencialaboral> getListaExperiencialaboral() {
        return listaExperiencialaboral;
    }

    public void setListaExperiencialaboral(List<Experiencialaboral> listaExperiencialaboral) {
        this.listaExperiencialaboral = listaExperiencialaboral;
    }

    public List <Estudios> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(List<Estudios> listaEstudios) {
        this.listaEstudios = listaEstudios;
    }

    public Estudios getEstudioSeleccionado() {
        return estudioSeleccionado;
    }

    public void setEstudioSeleccionado(Estudios estudioSeleccionado) {
        this.estudioSeleccionado = estudioSeleccionado;
    }

    public Experiencialaboral getExperienciaLaboralSeleccionada() {
        return experienciaLaboralSeleccionada;
    }

    public void setExperienciaLaboralSeleccionada(Experiencialaboral experienciaLaboralSeleccionada) {
        this.experienciaLaboralSeleccionada = experienciaLaboralSeleccionada;
    }
    
    public String doEditarUsuario (){
 
        return "modificar";
    }
    
    public String doBorrarEstudio(Estudios estudioSeleccionado){
        this.estudiosFacade.remove(estudioSeleccionado);
        this.init();
        return "perfil";
    }

    public String doEditarEstudio (Estudios estudioSeleccionado){
        this.estudioSeleccionado = estudioSeleccionado;
        return "modificarCrearEstudiosBean";
    }
    
    public String doAnadirEstudio(){
        this.estudioSeleccionado = null;
        return "modificarCrearEstudios";
    }
    
    public String doBorrarExperienciaLaboral(Experiencialaboral experiencialaboralseleccionada){
        this.experiencialaboralFacade.remove(experiencialaboralseleccionada);
        this.init();
        return "perfil";
    }
    
    public String doEditarExperienciaLaboral(Experiencialaboral experiencialaboralseleccionada){
        this.experienciaLaboralSeleccionada = experiencialaboralseleccionada;
        return "modificarCrearExperienciaLaboral";
    }
    
    public String doAnadirExperienciaLaboral (){
        this.experienciaLaboralSeleccionada = null;
        return "modificarCrearExperienciaLaboral";
    }
    
}
