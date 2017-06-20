/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Login;
import entity.Usuario;
import facade.LoginFacade;
import facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Usuario
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    private LoginFacade loginFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private String user = "";
    private String password = "";
    private List<Login> listaLogin;
    private List<Usuario> listaUser;
    private Usuario usuarioSeleccionado;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public String loguear(){
        if(user==null || user.isEmpty()){
            return("loginFallido");
        }else{
            listaLogin = this.loginFacade.encontrarUsuario(user, password);
            
            if(listaLogin.isEmpty()){
                return("loginFallido");
            }else{
                listaUser = this.usuarioFacade.encontrarPorId(listaLogin.get(0).getIdLogin());
                usuarioSeleccionado = listaUser.get(0);
                
                return("perfil");
            }
        }
    }
    
}
