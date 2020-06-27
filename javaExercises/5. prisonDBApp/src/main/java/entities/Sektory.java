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
@Table(name = "sektory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sektory.findAll", query = "SELECT s FROM Sektory s")
    , @NamedQuery(name = "Sektory.findByNazwa", query = "SELECT s FROM Sektory s WHERE s.nazwa = :nazwa")
    , @NamedQuery(name = "Sektory.findByIloscCel", query = "SELECT s FROM Sektory s WHERE s.iloscCel = :iloscCel")})
public class Sektory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @Basic(optional = false)
    @Column(name = "ilosc_cel")
    private int iloscCel;

    public Sektory() {
    }

    public Sektory(String nazwa) {
        this.nazwa = nazwa;
    }

    public Sektory(String nazwa, int iloscCel) {
        this.nazwa = nazwa;
        this.iloscCel = iloscCel;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIloscCel() {
        return iloscCel;
    }

    public void setIloscCel(int iloscCel) {
        this.iloscCel = iloscCel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazwa != null ? nazwa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sektory)) {
            return false;
        }
        Sektory other = (Sektory) object;
        if ((this.nazwa == null && other.nazwa != null) || (this.nazwa != null && !this.nazwa.equals(other.nazwa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sektory[ nazwa=" + nazwa + " ]";
    }
    
}
