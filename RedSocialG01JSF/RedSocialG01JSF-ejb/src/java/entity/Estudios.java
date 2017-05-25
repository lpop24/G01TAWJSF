/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudios.findAll", query = "SELECT e FROM Estudios e"),
    @NamedQuery(name = "Estudios.findByIdEstudios", query = "SELECT e FROM Estudios e WHERE e.idEstudios = :idEstudios"),
    @NamedQuery(name = "Estudios.findByFechaInicioEstudios", query = "SELECT e FROM Estudios e WHERE e.fechaInicioEstudios = :fechaInicioEstudios"),
    @NamedQuery(name = "Estudios.findByFechaFinEstudios", query = "SELECT e FROM Estudios e WHERE e.fechaFinEstudios = :fechaFinEstudios"),
    @NamedQuery(name = "Estudios.findByNombreCentro", query = "SELECT e FROM Estudios e WHERE e.nombreCentro = :nombreCentro"),
    @NamedQuery(name = "Estudios.findByDescripcionCentro", query = "SELECT e FROM Estudios e WHERE e.descripcionCentro = :descripcionCentro"),
    @NamedQuery(name = "Estudios.findByUbicacionCentro", query = "SELECT e FROM Estudios e WHERE e.ubicacionCentro = :ubicacionCentro")})
public class Estudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstudios")
    private Integer idEstudios;
    @Column(name = "fechaInicioEstudios")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioEstudios;
    @Column(name = "fechaFinEstudios")
    @Temporal(TemporalType.DATE)
    private Date fechaFinEstudios;
    @Size(max = 45)
    @Column(name = "nombreCentro")
    private String nombreCentro;
    @Size(max = 100)
    @Column(name = "descripcionCentro")
    private String descripcionCentro;
    @Size(max = 45)
    @Column(name = "ubicacionCentro")
    private String ubicacionCentro;
    @JoinColumn(name = "estudiosUsuarioFK", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario estudiosUsuarioFK;

    public Estudios() {
    }

    public Estudios(Integer idEstudios) {
        this.idEstudios = idEstudios;
    }

    public Integer getIdEstudios() {
        return idEstudios;
    }

    public void setIdEstudios(Integer idEstudios) {
        this.idEstudios = idEstudios;
    }

    public Date getFechaInicioEstudios() {
        return fechaInicioEstudios;
    }

    public void setFechaInicioEstudios(Date fechaInicioEstudios) {
        this.fechaInicioEstudios = fechaInicioEstudios;
    }

    public Date getFechaFinEstudios() {
        return fechaFinEstudios;
    }

    public void setFechaFinEstudios(Date fechaFinEstudios) {
        this.fechaFinEstudios = fechaFinEstudios;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDescripcionCentro() {
        return descripcionCentro;
    }

    public void setDescripcionCentro(String descripcionCentro) {
        this.descripcionCentro = descripcionCentro;
    }

    public String getUbicacionCentro() {
        return ubicacionCentro;
    }

    public void setUbicacionCentro(String ubicacionCentro) {
        this.ubicacionCentro = ubicacionCentro;
    }

    public Usuario getEstudiosUsuarioFK() {
        return estudiosUsuarioFK;
    }

    public void setEstudiosUsuarioFK(Usuario estudiosUsuarioFK) {
        this.estudiosUsuarioFK = estudiosUsuarioFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudios != null ? idEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudios)) {
            return false;
        }
        Estudios other = (Estudios) object;
        if ((this.idEstudios == null && other.idEstudios != null) || (this.idEstudios != null && !this.idEstudios.equals(other.idEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Estudios[ idEstudios=" + idEstudios + " ]";
    }
    
}
