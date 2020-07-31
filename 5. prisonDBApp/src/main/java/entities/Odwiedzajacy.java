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
@Table(name = "odwiedzajacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odwiedzajacy.findAll", query = "SELECT o FROM Odwiedzajacy o")
    , @NamedQuery(name = "Odwiedzajacy.findByPesel", query = "SELECT o FROM Odwiedzajacy o WHERE o.pesel = :pesel")
    , @NamedQuery(name = "Odwiedzajacy.findByImie", query = "SELECT o FROM Odwiedzajacy o WHERE o.imie = :imie")
    , @NamedQuery(name = "Odwiedzajacy.findByNazwisko", query = "SELECT o FROM Odwiedzajacy o WHERE o.nazwisko = :nazwisko")
    , @NamedQuery(name = "Odwiedzajacy.findByNrTel", query = "SELECT o FROM Odwiedzajacy o WHERE o.nrTel = :nrTel")
    , @NamedQuery(name = "Odwiedzajacy.findByAdres", query = "SELECT o FROM Odwiedzajacy o WHERE o.adres = :adres")
    , @NamedQuery(name = "Odwiedzajacy.findByInneUwagi", query = "SELECT o FROM Odwiedzajacy o WHERE o.inneUwagi = :inneUwagi")})
public class Odwiedzajacy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pesel")
    private String pesel;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "nr_tel")
    private String nrTel;
    @Basic(optional = false)
    @Column(name = "adres")
    private String adres;
    @Column(name = "inne_uwagi")
    private String inneUwagi;

    public Odwiedzajacy() {
    }

    public Odwiedzajacy(String pesel) {
        this.pesel = pesel;
    }

    public Odwiedzajacy(String pesel, String imie, String nrTel, String adres) {
        this.pesel = pesel;
        this.imie = imie;
        this.nrTel = nrTel;
        this.adres = adres;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getInneUwagi() {
        return inneUwagi;
    }

    public void setInneUwagi(String inneUwagi) {
        this.inneUwagi = inneUwagi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesel != null ? pesel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odwiedzajacy)) {
            return false;
        }
        Odwiedzajacy other = (Odwiedzajacy) object;
        if ((this.pesel == null && other.pesel != null) || (this.pesel != null && !this.pesel.equals(other.pesel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Odwiedzajacy[ pesel=" + pesel + " ]";
    }
    
}
