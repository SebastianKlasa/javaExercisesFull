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
@Table(name = "straznicy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Straznicy.findAll", query = "SELECT s FROM Straznicy s")
    , @NamedQuery(name = "Straznicy.findByPesel", query = "SELECT s FROM Straznicy s WHERE s.pesel = :pesel")
    , @NamedQuery(name = "Straznicy.findByImie", query = "SELECT s FROM Straznicy s WHERE s.imie = :imie")
    , @NamedQuery(name = "Straznicy.findByNazwisko", query = "SELECT s FROM Straznicy s WHERE s.nazwisko = :nazwisko")
    , @NamedQuery(name = "Straznicy.findByNrTel", query = "SELECT s FROM Straznicy s WHERE s.nrTel = :nrTel")
    , @NamedQuery(name = "Straznicy.findByAdres", query = "SELECT s FROM Straznicy s WHERE s.adres = :adres")
    , @NamedQuery(name = "Straznicy.findByDataZatrudnienia", query = "SELECT s FROM Straznicy s WHERE s.dataZatrudnienia = :dataZatrudnienia")
    , @NamedQuery(name = "Straznicy.findByDataZwolnienia", query = "SELECT s FROM Straznicy s WHERE s.dataZwolnienia = :dataZwolnienia")
    , @NamedQuery(name = "Straznicy.findByPoprzednieStanowisko", query = "SELECT s FROM Straznicy s WHERE s.poprzednieStanowisko = :poprzednieStanowisko")})
public class Straznicy implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "data_zatrudnienia")
    @Temporal(TemporalType.DATE)
    private Date dataZatrudnienia;
    @Column(name = "data_zwolnienia")
    @Temporal(TemporalType.DATE)
    private Date dataZwolnienia;
    @Column(name = "poprzednie_stanowisko")
    private String poprzednieStanowisko;

    public Straznicy() {
    }

    public Straznicy(String pesel) {
        this.pesel = pesel;
    }

    public Straznicy(String pesel, String imie, String nrTel, String adres, Date dataZatrudnienia) {
        this.pesel = pesel;
        this.imie = imie;
        this.nrTel = nrTel;
        this.adres = adres;
        this.dataZatrudnienia = dataZatrudnienia;
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

    public Date getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public Date getDataZwolnienia() {
        return dataZwolnienia;
    }

    public void setDataZwolnienia(Date dataZwolnienia) {
        this.dataZwolnienia = dataZwolnienia;
    }

    public String getPoprzednieStanowisko() {
        return poprzednieStanowisko;
    }

    public void setPoprzednieStanowisko(String poprzednieStanowisko) {
        this.poprzednieStanowisko = poprzednieStanowisko;
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
        if (!(object instanceof Straznicy)) {
            return false;
        }
        Straznicy other = (Straznicy) object;
        if ((this.pesel == null && other.pesel != null) || (this.pesel != null && !this.pesel.equals(other.pesel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Straznicy[ pesel=" + pesel + " ]";
    }
    
}
