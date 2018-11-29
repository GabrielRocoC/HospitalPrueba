/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabrielroco
 */
@Entity
@Table(name = "Especializacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especializacion.findAll", query = "SELECT e FROM Especializacion e")
    , @NamedQuery(name = "Especializacion.findByIdE", query = "SELECT e FROM Especializacion e WHERE e.idE = :idE")
    , @NamedQuery(name = "Especializacion.findByTipoEspecialidad", query = "SELECT e FROM Especializacion e WHERE e.tipoEspecialidad = :tipoEspecialidad")})
public class Especializacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idE")
    private Integer idE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipoEspecialidad")
    private String tipoEspecialidad;
    @JoinColumn(name = "rutM", referencedColumnName = "rutM")
    @ManyToOne(optional = false)
    private Medico rutM;

    public Especializacion() {
    }

    public Especializacion(Integer idE) {
        this.idE = idE;
    }

    public Especializacion(Integer idE, String tipoEspecialidad) {
        this.idE = idE;
        this.tipoEspecialidad = tipoEspecialidad;
    }

    public Integer getIdE() {
        return idE;
    }

    public void setIdE(Integer idE) {
        this.idE = idE;
    }

    public String getTipoEspecialidad() {
        return tipoEspecialidad;
    }

    public void setTipoEspecialidad(String tipoEspecialidad) {
        this.tipoEspecialidad = tipoEspecialidad;
    }

    public Medico getRutM() {
        return rutM;
    }

    public void setRutM(Medico rutM) {
        this.rutM = rutM;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idE != null ? idE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especializacion)) {
            return false;
        }
        Especializacion other = (Especializacion) object;
        if ((this.idE == null && other.idE != null) || (this.idE != null && !this.idE.equals(other.idE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Especializacion[ idE=" + idE + " ]";
    }
    
}
