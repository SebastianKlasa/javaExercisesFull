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
@Table(name = "prace_wiez")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PraceWiez.findAll", query = "SELECT p FROM PraceWiez p")
    , @NamedQuery(name = "PraceWiez.findByIdWiezien", query = "SELECT p FROM PraceWiez p WHERE p.praceWiezPK.idWiezien = :idWiezien")
    , @NamedQuery(name = "PraceWiez.findByIdPraca", query = "SELECT p FROM PraceWiez p WHERE p.praceWiezPK.idPraca = :idPraca")})
public class PraceWiez implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PraceWiezPK praceWiezPK;

    public PraceWiez() {
    }

    public PraceWiez(PraceWiezPK praceWiezPK) {
        this.praceWiezPK = praceWiezPK;
    }

    public PraceWiez(String idWiezien, int idPraca) {
        this.praceWiezPK = new PraceWiezPK(idWiezien, idPraca);
    }

    public PraceWiezPK getPraceWiezPK() {
        return praceWiezPK;
    }

    public void setPraceWiezPK(PraceWiezPK praceWiezPK) {
        this.praceWiezPK = praceWiezPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (praceWiezPK != null ? praceWiezPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PraceWiez)) {
            return false;
        }
        PraceWiez other = (PraceWiez) object;
        if ((this.praceWiezPK == null && other.praceWiezPK != null) || (this.praceWiezPK != null && !this.praceWiezPK.equals(other.praceWiezPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PraceWiez[ praceWiezPK=" + praceWiezPK + " ]";
    }
    
}
