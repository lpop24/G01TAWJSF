/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

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
    
    
    protected List<Usuario> usuario;
    protected Usuario usuarioSeleccionado;
    
    public PerfilBean() {
    }

    @PostConstruct
    public void init() {
        this.usuario = this.usuarioFacade.findAll();
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
    
    
    
    
    


    
}
