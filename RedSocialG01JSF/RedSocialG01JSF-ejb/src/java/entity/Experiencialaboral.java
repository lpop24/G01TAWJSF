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
@Table(name = "experiencialaboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencialaboral.findAll", query = "SELECT e FROM Experiencialaboral e"),
    @NamedQuery(name = "Experiencialaboral.findByIdExperienciaLaboral", query = "SELECT e FROM Experiencialaboral e WHERE e.idExperienciaLaboral = :idExperienciaLaboral"),
    @NamedQuery(name = "Experiencialaboral.findByFechaInicioLaboral", query = "SELECT e FROM Experiencialaboral e WHERE e.fechaInicioLaboral = :fechaInicioLaboral"),
    @NamedQuery(name = "Experiencialaboral.findByFechaFinLaboral", query = "SELECT e FROM Experiencialaboral e WHERE e.fechaFinLaboral = :fechaFinLaboral"),
    @NamedQuery(name = "Experiencialaboral.findByNombreEmpresa", query = "SELECT e FROM Experiencialaboral e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Experiencialaboral.findByUbicacionEmpresa", query = "SELECT e FROM Experiencialaboral e WHERE e.ubicacionEmpresa = :ubicacionEmpresa"),
    @NamedQuery(name = "Experiencialaboral.findByPaginaWebEmpresa", query = "SELECT e FROM Experiencialaboral e WHERE e.paginaWebEmpresa = :paginaWebEmpresa"),
    @NamedQuery(name = "Experiencialaboral.findByDescripcionEmpresa", query = "SELECT e FROM Experiencialaboral e WHERE e.descripcionEmpresa = :descripcionEmpresa"),
    @NamedQuery(name = "Experiencialaboral.findByPuesto", query = "SELECT e FROM Experiencialaboral e WHERE e.puesto = :puesto")})
public class Experiencialaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExperienciaLaboral")
    private Integer idExperienciaLaboral;
    @Column(name = "fechaInicioLaboral")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioLaboral;
    @Column(name = "fechaFinLaboral")
    @Temporal(TemporalType.DATE)
    private Date fechaFinLaboral;
    @Size(max = 45)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Size(max = 45)
    @Column(name = "ubicacionEmpresa")
    private String ubicacionEmpresa;
    @Size(max = 45)
    @Column(name = "paginaWebEmpresa")
    private String paginaWebEmpresa;
    @Size(max = 100)
    @Column(name = "descripcionEmpresa")
    private String descripcionEmpresa;
    @Size(max = 45)
    @Column(name = "puesto")
    private String puesto;
    @JoinColumn(name = "expLaboralUsuarioFK", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario expLaboralUsuarioFK;

    public Experiencialaboral() {
    }

    public Experiencialaboral(Integer idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public Integer getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Integer idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public Date getFechaInicioLaboral() {
        return fechaInicioLaboral;
    }

    public void setFechaInicioLaboral(Date fechaInicioLaboral) {
        this.fechaInicioLaboral = fechaInicioLaboral;
    }

    public Date getFechaFinLaboral() {
        return fechaFinLaboral;
    }

    public void setFechaFinLaboral(Date fechaFinLaboral) {
        this.fechaFinLaboral = fechaFinLaboral;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getUbicacionEmpresa() {
        return ubicacionEmpresa;
    }

    public void setUbicacionEmpresa(String ubicacionEmpresa) {
        this.ubicacionEmpresa = ubicacionEmpresa;
    }

    public String getPaginaWebEmpresa() {
        return paginaWebEmpresa;
    }

    public void setPaginaWebEmpresa(String paginaWebEmpresa) {
        this.paginaWebEmpresa = paginaWebEmpresa;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Usuario getExpLaboralUsuarioFK() {
        return expLaboralUsuarioFK;
    }

    public void setExpLaboralUsuarioFK(Usuario expLaboralUsuarioFK) {
        this.expLaboralUsuarioFK = expLaboralUsuarioFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExperienciaLaboral != null ? idExperienciaLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencialaboral)) {
            return false;
        }
        Experiencialaboral other = (Experiencialaboral) object;
        if ((this.idExperienciaLaboral == null && other.idExperienciaLaboral != null) || (this.idExperienciaLaboral != null && !this.idExperienciaLaboral.equals(other.idExperienciaLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Experiencialaboral[ idExperienciaLaboral=" + idExperienciaLaboral + " ]";
    }
    
}
