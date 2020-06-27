/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "cele")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cele.findAll", query = "SELECT c FROM Cele c")
    , @NamedQuery(name = "Cele.findByNr", query = "SELECT c FROM Cele c WHERE c.nr = :nr")
    , @NamedQuery(name = "Cele.findByIloscMiejsc", query = "SELECT c FROM Cele c WHERE c.iloscMiejsc = :iloscMiejsc")
    , @NamedQuery(name = "Cele.findByPowierzchnia", query = "SELECT c FROM Cele c WHERE c.powierzchnia = :powierzchnia")
    , @NamedQuery(name = "Cele.findByIdSektor", query = "SELECT c FROM Cele c WHERE c.idSektor = :idSektor")})
public class Cele implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nr")
    private Integer nr;
    @Basic(optional = false)
    @Column(name = "ilosc_miejsc")
    private int iloscMiejsc;
    @Basic(optional = false)
    @Column(name = "powierzchnia")
    private float powierzchnia;
    @Column(name = "id_sektor")
    private Character idSektor;

    public Cele() {
    }

    public Cele(Integer nr) {
        this.nr = nr;
    }

    public Cele(Integer nr, int iloscMiejsc, float powierzchnia) {
        this.nr = nr;
        this.iloscMiejsc = iloscMiejsc;
        this.powierzchnia = powierzchnia;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public float getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(float powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public Character getIdSektor() {
        return idSektor;
    }

    public void setIdSektor(Character idSektor) {
        this.idSektor = idSektor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nr != null ? nr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cele)) {
            return false;
        }
        Cele other = (Cele) object;
        if ((this.nr == null && other.nr != null) || (this.nr != null && !this.nr.equals(other.nr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cele[ nr=" + nr + " ]";
    }
    
}
