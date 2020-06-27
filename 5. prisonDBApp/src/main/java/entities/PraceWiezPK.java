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
public class PraceWiezPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_wiezien")
    private String idWiezien;
    @Basic(optional = false)
    @Column(name = "id_praca")
    private int idPraca;

    public PraceWiezPK() {
    }

    public PraceWiezPK(String idWiezien, int idPraca) {
        this.idWiezien = idWiezien;
        this.idPraca = idPraca;
    }

    public String getIdWiezien() {
        return idWiezien;
    }

    public void setIdWiezien(String idWiezien) {
        this.idWiezien = idWiezien;
    }

    public int getIdPraca() {
        return idPraca;
    }

    public void setIdPraca(int idPraca) {
        this.idPraca = idPraca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWiezien != null ? idWiezien.hashCode() : 0);
        hash += (int) idPraca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PraceWiezPK)) {
            return false;
        }
        PraceWiezPK other = (PraceWiezPK) object;
        if ((this.idWiezien == null && other.idWiezien != null) || (this.idWiezien != null && !this.idWiezien.equals(other.idWiezien))) {
            return false;
        }
        if (this.idPraca != other.idPraca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PraceWiezPK[ idWiezien=" + idWiezien + ", idPraca=" + idPraca + " ]";
    }
    
}
