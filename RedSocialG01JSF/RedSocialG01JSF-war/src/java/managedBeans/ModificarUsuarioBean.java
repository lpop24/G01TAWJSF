/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Usuario;
import facade.UsuarioFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named
@RequestScoped
public class ModificarUsuarioBean {
    
    @EJB
    private UsuarioFacade usuarioFacade;

    @Inject LoginBean loginBean;
    
    protected Usuario usuario;
    /**
     * Creates a new instance of ModificarUsuarioMB
     */
    public ModificarUsuarioBean() {
    }
    
    @PostConstruct
    public void init()
    {
        if(loginBean.getUsuarioSeleccionado() == null)
            usuario = new Usuario();
        else
            usuario = loginBean.getUsuarioSeleccionado();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String doGuardar()
    {
        usuarioFacade.edit(usuario);
        return "perfil";
    }
    
}
