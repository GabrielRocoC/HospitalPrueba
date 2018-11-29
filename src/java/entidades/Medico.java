/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gabrielroco
 */
@Entity
@Table(name = "Medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByRutM", query = "SELECT m FROM Medico m WHERE m.rutM = :rutM")
    , @NamedQuery(name = "Medico.findByNombreM", query = "SELECT m FROM Medico m WHERE m.nombreM = :nombreM")
    , @NamedQuery(name = "Medico.findByApellidoM", query = "SELECT m FROM Medico m WHERE m.apellidoM = :apellidoM")
    , @NamedQuery(name = "Medico.findByArea", query = "SELECT m FROM Medico m WHERE m.area = :area")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rutM")
    private String rutM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreM")
    private String nombreM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellidoM")
    private String apellidoM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "area")
    private String area;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutM")
    private Collection<Especializacion> especializacionCollection;

    public Medico() {
    }

    public Medico(String rutM) {
        this.rutM = rutM;
    }

    public Medico(String rutM, String nombreM, String apellidoM, String area) {
        this.rutM = rutM;
        this.nombreM = nombreM;
        this.apellidoM = apellidoM;
        this.area = area;
    }

    public String getRutM() {
        return rutM;
    }

    public void setRutM(String rutM) {
        this.rutM = rutM;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlTransient
    public Collection<Especializacion> getEspecializacionCollection() {
        return especializacionCollection;
    }

    public void setEspecializacionCollection(Collection<Especializacion> especializacionCollection) {
        this.especializacionCollection = especializacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutM != null ? rutM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.rutM == null && other.rutM != null) || (this.rutM != null && !this.rutM.equals(other.rutM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Medico[ rutM=" + rutM + " ]";
    }
    
}
