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
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Loubna Channouf Cherradi
 */
@Named(value = "crearUsuarioBean")
@RequestScoped
public class CrearUsuarioBean {

    @EJB
    private LoginFacade loginFacade;

    @EJB
    private UsuarioFacade usuarioFacade;  
    
    
    
    protected String usuarioLogin;
    protected String password;
    
    Login login = new Login();
    
       
    
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String instagram;
    private String correoElectronico;
    private String twitter;
    private String telefono;
    private String paginaWebUsuario;
    private String aficiones;
    private String foto;
    private String ciudad;
    
    Usuario usuario = new Usuario(); 
    

    /**
     * Creates a new instance of CrearUsuarioMB
     */
    public CrearUsuarioBean() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWebUsuario() {
        return paginaWebUsuario;
    }

    public void setPaginaWebUsuario(String paginaWebUsuario) {
        this.paginaWebUsuario = paginaWebUsuario;
    }

    public String getAficiones() {
        return aficiones;
    }

    public void setAficiones(String aficiones) {
        this.aficiones = aficiones;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public String doGuardar(){
        login.setUsuarioLogin(usuarioLogin);
        login.setPassword(password);
        this.loginFacade.create(login);
        
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setInstagram(instagram);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setTwitter(twitter);
        usuario.setPaginaWebUsuario(paginaWebUsuario);
        usuario.setAficiones(aficiones);
        usuario.setTelefono(telefono);
        usuario.setCiudad(ciudad);       
        usuario.setLoginFK(login);

        this.usuarioFacade.create(usuario);
        return "usuarioCreado";
    }
    
    public String doCancelar(){
        return "login";
    }
    
}
