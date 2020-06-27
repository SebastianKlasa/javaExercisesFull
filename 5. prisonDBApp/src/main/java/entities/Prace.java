/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "prace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prace.findAll", query = "SELECT p FROM Prace p")
    , @NamedQuery(name = "Prace.findById", query = "SELECT p FROM Prace p WHERE p.id = :id")
    , @NamedQuery(name = "Prace.findByRodzaj", query = "SELECT p FROM Prace p WHERE p.rodzaj = :rodzaj")
    , @NamedQuery(name = "Prace.findByDzienTygodnia", query = "SELECT p FROM Prace p WHERE p.dzienTygodnia = :dzienTygodnia")
    , @NamedQuery(name = "Prace.findByGodzinaRozpoczecia", query = "SELECT p FROM Prace p WHERE p.godzinaRozpoczecia = :godzinaRozpoczecia")
    , @NamedQuery(name = "Prace.findByGodzinaZakonczenia", query = "SELECT p FROM Prace p WHERE p.godzinaZakonczenia = :godzinaZakonczenia")})
public class Prace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "rodzaj")
    private String rodzaj;
    @Basic(optional = false)
    @Column(name = "dzien_tygodnia")
    private String dzienTygodnia;
    @Basic(optional = false)
    @Column(name = "godzina_rozpoczecia")
    @Temporal(TemporalType.TIME)
    private Date godzinaRozpoczecia;
    @Basic(optional = false)
    @Column(name = "godzina_zakonczenia")
    @Temporal(TemporalType.TIME)
    private Date godzinaZakonczenia;

    public Prace() {
    }

    public Prace(Integer id) {
        this.id = id;
    }

    public Prace(Integer id, String rodzaj, String dzienTygodnia, Date godzinaRozpoczecia, Date godzinaZakonczenia) {
        this.id = id;
        this.rodzaj = rodzaj;
        this.dzienTygodnia = dzienTygodnia;
        this.godzinaRozpoczecia = godzinaRozpoczecia;
        this.godzinaZakonczenia = godzinaZakonczenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(String dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    public Date getGodzinaRozpoczecia() {
        return godzinaRozpoczecia;
    }

    public void setGodzinaRozpoczecia(Date godzinaRozpoczecia) {
        this.godzinaRozpoczecia = godzinaRozpoczecia;
    }

    public Date getGodzinaZakonczenia() {
        return godzinaZakonczenia;
    }

    public void setGodzinaZakonczenia(Date godzinaZakonczenia) {
        this.godzinaZakonczenia = godzinaZakonczenia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prace)) {
            return false;
        }
        Prace other = (Prace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Prace[ id=" + id + " ]";
    }
    
}
