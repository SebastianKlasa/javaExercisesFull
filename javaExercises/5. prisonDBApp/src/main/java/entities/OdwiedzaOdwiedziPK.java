/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sebas
 */
@Embeddable
public class OdwiedzaOdwiedziPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_odwiedzajacy")
    private String idOdwiedzajacy;
    @Basic(optional = false)
    @Column(name = "id_odwiedziny")
    private int idOdwiedziny;

    public OdwiedzaOdwiedziPK() {
    }

    public OdwiedzaOdwiedziPK(String idOdwiedzajacy, int idOdwiedziny) {
        this.idOdwiedzajacy = idOdwiedzajacy;
        this.idOdwiedziny = idOdwiedziny;
    }

    public String getIdOdwiedzajacy() {
        return idOdwiedzajacy;
    }

    public void setIdOdwiedzajacy(String idOdwiedzajacy) {
        this.idOdwiedzajacy = idOdwiedzajacy;
    }

    public int getIdOdwiedziny() {
        return idOdwiedziny;
    }

    public void setIdOdwiedziny(int idOdwiedziny) {
        this.idOdwiedziny = idOdwiedziny;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOdwiedzajacy != null ? idOdwiedzajacy.hashCode() : 0);
        hash += (int) idOdwiedziny;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdwiedzaOdwiedziPK)) {
            return false;
        }
        OdwiedzaOdwiedziPK other = (OdwiedzaOdwiedziPK) object;
        if ((this.idOdwiedzajacy == null && other.idOdwiedzajacy != null) || (this.idOdwiedzajacy != null && !this.idOdwiedzajacy.equals(other.idOdwiedzajacy))) {
            return false;
        }
        if (this.idOdwiedziny != other.idOdwiedziny) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OdwiedzaOdwiedziPK[ idOdwiedzajacy=" + idOdwiedzajacy + ", idOdwiedziny=" + idOdwiedziny + " ]";
    }
    
}
