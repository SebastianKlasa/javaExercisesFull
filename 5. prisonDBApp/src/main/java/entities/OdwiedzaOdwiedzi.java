/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "odwiedza_odwiedzi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdwiedzaOdwiedzi.findAll", query = "SELECT o FROM OdwiedzaOdwiedzi o")
    , @NamedQuery(name = "OdwiedzaOdwiedzi.findByIdOdwiedzajacy", query = "SELECT o FROM OdwiedzaOdwiedzi o WHERE o.odwiedzaOdwiedziPK.idOdwiedzajacy = :idOdwiedzajacy")
    , @NamedQuery(name = "OdwiedzaOdwiedzi.findByIdOdwiedziny", query = "SELECT o FROM OdwiedzaOdwiedzi o WHERE o.odwiedzaOdwiedziPK.idOdwiedziny = :idOdwiedziny")})
public class OdwiedzaOdwiedzi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OdwiedzaOdwiedziPK odwiedzaOdwiedziPK;

    public OdwiedzaOdwiedzi() {
    }

    public OdwiedzaOdwiedzi(OdwiedzaOdwiedziPK odwiedzaOdwiedziPK) {
        this.odwiedzaOdwiedziPK = odwiedzaOdwiedziPK;
    }

    public OdwiedzaOdwiedzi(String idOdwiedzajacy, int idOdwiedziny) {
        this.odwiedzaOdwiedziPK = new OdwiedzaOdwiedziPK(idOdwiedzajacy, idOdwiedziny);
    }

    public OdwiedzaOdwiedziPK getOdwiedzaOdwiedziPK() {
        return odwiedzaOdwiedziPK;
    }

    public void setOdwiedzaOdwiedziPK(OdwiedzaOdwiedziPK odwiedzaOdwiedziPK) {
        this.odwiedzaOdwiedziPK = odwiedzaOdwiedziPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odwiedzaOdwiedziPK != null ? odwiedzaOdwiedziPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdwiedzaOdwiedzi)) {
            return false;
        }
        OdwiedzaOdwiedzi other = (OdwiedzaOdwiedzi) object;
        if ((this.odwiedzaOdwiedziPK == null && other.odwiedzaOdwiedziPK != null) || (this.odwiedzaOdwiedziPK != null && !this.odwiedzaOdwiedziPK.equals(other.odwiedzaOdwiedziPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OdwiedzaOdwiedzi[ odwiedzaOdwiedziPK=" + odwiedzaOdwiedziPK + " ]";
    }
    
}
