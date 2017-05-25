/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "notificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaciones.findAll", query = "SELECT n FROM Notificaciones n"),
    @NamedQuery(name = "Notificaciones.findByIdNotificaciones", query = "SELECT n FROM Notificaciones n WHERE n.idNotificaciones = :idNotificaciones")})
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNotificaciones")
    private Integer idNotificaciones;
    @Lob
    @Column(name = "peticionAmistad")
    private byte[] peticionAmistad;
    @JoinColumn(name = "usuarioEmisorNotificacion", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario usuarioEmisorNotificacion;
    @JoinColumn(name = "usuarioReceptorNotificacion", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario usuarioReceptorNotificacion;
    @OneToMany(mappedBy = "notificacionMensaje")
    private Collection<Mensaje> mensajeCollection;

    public Notificaciones() {
    }

    public Notificaciones(Integer idNotificaciones) {
        this.idNotificaciones = idNotificaciones;
    }

    public Integer getIdNotificaciones() {
        return idNotificaciones;
    }

    public void setIdNotificaciones(Integer idNotificaciones) {
        this.idNotificaciones = idNotificaciones;
    }

    public byte[] getPeticionAmistad() {
        return peticionAmistad;
    }

    public void setPeticionAmistad(byte[] peticionAmistad) {
        this.peticionAmistad = peticionAmistad;
    }

    public Usuario getUsuarioEmisorNotificacion() {
        return usuarioEmisorNotificacion;
    }

    public void setUsuarioEmisorNotificacion(Usuario usuarioEmisorNotificacion) {
        this.usuarioEmisorNotificacion = usuarioEmisorNotificacion;
    }

    public Usuario getUsuarioReceptorNotificacion() {
        return usuarioReceptorNotificacion;
    }

    public void setUsuarioReceptorNotificacion(Usuario usuarioReceptorNotificacion) {
        this.usuarioReceptorNotificacion = usuarioReceptorNotificacion;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificaciones != null ? idNotificaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificaciones)) {
            return false;
        }
        Notificaciones other = (Notificaciones) object;
        if ((this.idNotificaciones == null && other.idNotificaciones != null) || (this.idNotificaciones != null && !this.idNotificaciones.equals(other.idNotificaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Notificaciones[ idNotificaciones=" + idNotificaciones + " ]";
    }
    
}
