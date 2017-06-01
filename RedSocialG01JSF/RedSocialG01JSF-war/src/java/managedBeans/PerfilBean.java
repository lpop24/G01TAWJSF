/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Estudios;
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

/**
 *
 * @author Alberto Cazorla Suarez
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
    
    
    //protected List<Usuario> usuario; // creo que esto no sirve pa na
    protected Usuario usuarioSeleccionado;
    protected List<Experiencialaboral> listaExperiencialaboral;
    protected List<Estudios> listaEstudios;
    protected Estudios estudioSeleccionado;
    protected Experiencialaboral experienciaLaboralSeleccionada;
    
    
    public PerfilBean() {
    }

    @PostConstruct
    public void init() {
        this.usuarioSeleccionado = this.usuarioFacade.find("id");//esto deberia buscar el usuario cogiendo el id de algun sitio
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

    public List<Estudios> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(List<Estudios> listaEstudios) {
        this.listaEstudios = listaEstudios;
    }
    
    public String doEditarUsuario (Usuario usuarioSeleccionado){
        this.usuarioSeleccionado = usuarioSeleccionado;
        return "modificarUsuarioBean";
    }
    
    public String doBorrarEstudio(Estudios estudioSeleccionado){
        this.estudiosFacade.remove(estudioSeleccionado);
        this.init();
        return "perfil";
    }

    public String doEditarEstudio (Estudios estudioSeleccionado){
        this.estudioSeleccionado = estudioSeleccionado;
        return "modificarEstudiosBean";
    }
    
    public String doAnyadirEstudio(Usuario usuarioSeleccionado){
        this.usuarioSeleccionado = usuarioSeleccionado;
        return "crearEstudiosBean";
    }
    
    public String doBorrarExperienciaLaboral(Experiencialaboral experiencialaboralseleccionada){
        this.experiencialaboralFacade.remove(experiencialaboralseleccionada);
        this.init();
        return "perfil";
    }
    
    public String doEditarExperienciaLaboral(Experiencialaboral experiencialaboralseleccionada){
        this.experienciaLaboralSeleccionada = experiencialaboralseleccionada;
        return "modificarExperienciaLaboralBean";
    }
    
    public String doAnyadirExperienciaLaboral (Usuario usuarioSeleccionado){
        this.usuarioSeleccionado = usuarioSeleccionado;
        return "crearExperienciaLaboralBean";
    }
    
}
