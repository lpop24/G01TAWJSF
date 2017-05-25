/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuario.findByInstagram", query = "SELECT u FROM Usuario u WHERE u.instagram = :instagram"),
    @NamedQuery(name = "Usuario.findByCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuario.findByTwitter", query = "SELECT u FROM Usuario u WHERE u.twitter = :twitter"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByPaginaWebUsuario", query = "SELECT u FROM Usuario u WHERE u.paginaWebUsuario = :paginaWebUsuario"),
    @NamedQuery(name = "Usuario.findByAficiones", query = "SELECT u FROM Usuario u WHERE u.aficiones = :aficiones"),
    @NamedQuery(name = "Usuario.findByCiudad", query = "SELECT u FROM Usuario u WHERE u.ciudad = :ciudad")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "instagram")
    private String instagram;
    @Size(max = 45)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Size(max = 45)
    @Column(name = "twitter")
    private String twitter;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "paginaWebUsuario")
    private String paginaWebUsuario;
    @Size(max = 150)
    @Column(name = "aficiones")
    private String aficiones;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @JoinTable(name = "usuario_has_usuario", joinColumns = {
        @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "Usuario_idUsuario1", referencedColumnName = "idUsuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Usuario> usuarioCollection1;
    @OneToMany(mappedBy = "usuarioEmisorNotificacion")
    private Collection<Notificaciones> notificacionesCollection;
    @OneToMany(mappedBy = "usuarioReceptorNotificacion")
    private Collection<Notificaciones> notificacionesCollection1;
    @JoinColumn(name = "loginFK", referencedColumnName = "idLogin")
    @ManyToOne
    private Login loginFK;
    @OneToMany(mappedBy = "usuarioEmisor")
    private Collection<Mensaje> mensajeCollection;
    @OneToMany(mappedBy = "usuarioReceptor")
    private Collection<Mensaje> mensajeCollection1;
    @OneToMany(mappedBy = "estudiosUsuarioFK")
    private Collection<Estudios> estudiosCollection;
    @OneToMany(mappedBy = "expLaboralUsuarioFK")
    private Collection<Experiencialaboral> experiencialaboralCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String apellidos) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection1() {
        return usuarioCollection1;
    }

    public void setUsuarioCollection1(Collection<Usuario> usuarioCollection1) {
        this.usuarioCollection1 = usuarioCollection1;
    }

    @XmlTransient
    public Collection<Notificaciones> getNotificacionesCollection() {
        return notificacionesCollection;
    }

    public void setNotificacionesCollection(Collection<Notificaciones> notificacionesCollection) {
        this.notificacionesCollection = notificacionesCollection;
    }

    @XmlTransient
    public Collection<Notificaciones> getNotificacionesCollection1() {
        return notificacionesCollection1;
    }

    public void setNotificacionesCollection1(Collection<Notificaciones> notificacionesCollection1) {
        this.notificacionesCollection1 = notificacionesCollection1;
    }

    public Login getLoginFK() {
        return loginFK;
    }

    public void setLoginFK(Login loginFK) {
        this.loginFK = loginFK;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection1() {
        return mensajeCollection1;
    }

    public void setMensajeCollection1(Collection<Mensaje> mensajeCollection1) {
        this.mensajeCollection1 = mensajeCollection1;
    }

    @XmlTransient
    public Collection<Estudios> getEstudiosCollection() {
        return estudiosCollection;
    }

    public void setEstudiosCollection(Collection<Estudios> estudiosCollection) {
        this.estudiosCollection = estudiosCollection;
    }

    @XmlTransient
    public Collection<Experiencialaboral> getExperiencialaboralCollection() {
        return experiencialaboralCollection;
    }

    public void setExperiencialaboralCollection(Collection<Experiencialaboral> experiencialaboralCollection) {
        this.experiencialaboralCollection = experiencialaboralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
