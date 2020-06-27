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
import javax.persistence.Lob;
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
@Table(name = "wiezniowie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wiezniowie.findAll", query = "SELECT w FROM Wiezniowie w")
    , @NamedQuery(name = "Wiezniowie.findByPesel", query = "SELECT w FROM Wiezniowie w WHERE w.pesel = :pesel")
    , @NamedQuery(name = "Wiezniowie.findByImie", query = "SELECT w FROM Wiezniowie w WHERE w.imie = :imie")
    , @NamedQuery(name = "Wiezniowie.findByNazwisko", query = "SELECT w FROM Wiezniowie w WHERE w.nazwisko = :nazwisko")
    , @NamedQuery(name = "Wiezniowie.findByDataRozpoczeciaKary", query = "SELECT w FROM Wiezniowie w WHERE w.dataRozpoczeciaKary = :dataRozpoczeciaKary")
    , @NamedQuery(name = "Wiezniowie.findByDataZakonczeniaKary", query = "SELECT w FROM Wiezniowie w WHERE w.dataZakonczeniaKary = :dataZakonczeniaKary")
    , @NamedQuery(name = "Wiezniowie.findByDataZwolnieniaWarunkowego", query = "SELECT w FROM Wiezniowie w WHERE w.dataZwolnieniaWarunkowego = :dataZwolnieniaWarunkowego")
    , @NamedQuery(name = "Wiezniowie.findByCzyZwolnicWarunkowo", query = "SELECT w FROM Wiezniowie w WHERE w.czyZwolnicWarunkowo = :czyZwolnicWarunkowo")
    , @NamedQuery(name = "Wiezniowie.findByIdCela", query = "SELECT w FROM Wiezniowie w WHERE w.idCela = :idCela")})
public class Wiezniowie implements Serializable {

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
    @Column(name = "data_rozpoczecia_kary")
    @Temporal(TemporalType.DATE)
    private Date dataRozpoczeciaKary;
    @Column(name = "data_zakonczenia_kary")
    @Temporal(TemporalType.DATE)
    private Date dataZakonczeniaKary;
    @Column(name = "data_zwolnienia_warunkowego")
    @Temporal(TemporalType.DATE)
    private Date dataZwolnieniaWarunkowego;
    @Column(name = "czy_zwolnic_warunkowo")
    private String czyZwolnicWarunkowo;
    @Lob
    @Column(name = "akta")
    private String akta;
    @Lob
    @Column(name = "uwagi")
    private String uwagi;
    @Column(name = "id_cela")
    private Integer idCela;

    public Wiezniowie() {
    }

    public Wiezniowie(String pesel) {
        this.pesel = pesel;
    }

    public Wiezniowie(String pesel, String imie, Date dataRozpoczeciaKary) {
        this.pesel = pesel;
        this.imie = imie;
        this.dataRozpoczeciaKary = dataRozpoczeciaKary;
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

    public Date getDataRozpoczeciaKary() {
        return dataRozpoczeciaKary;
    }

    public void setDataRozpoczeciaKary(Date dataRozpoczeciaKary) {
        this.dataRozpoczeciaKary = dataRozpoczeciaKary;
    }

    public Date getDataZakonczeniaKary() {
        return dataZakonczeniaKary;
    }

    public void setDataZakonczeniaKary(Date dataZakonczeniaKary) {
        this.dataZakonczeniaKary = dataZakonczeniaKary;
    }

    public Date getDataZwolnieniaWarunkowego() {
        return dataZwolnieniaWarunkowego;
    }

    public void setDataZwolnieniaWarunkowego(Date dataZwolnieniaWarunkowego) {
        this.dataZwolnieniaWarunkowego = dataZwolnieniaWarunkowego;
    }

    public String getCzyZwolnicWarunkowo() {
        return czyZwolnicWarunkowo;
    }

    public void setCzyZwolnicWarunkowo(String czyZwolnicWarunkowo) {
        this.czyZwolnicWarunkowo = czyZwolnicWarunkowo;
    }

    public String getAkta() {
        return akta;
    }

    public void setAkta(String akta) {
        this.akta = akta;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public Integer getIdCela() {
        return idCela;
    }

    public void setIdCela(Integer idCela) {
        this.idCela = idCela;
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
        if (!(object instanceof Wiezniowie)) {
            return false;
        }
        Wiezniowie other = (Wiezniowie) object;
        if ((this.pesel == null && other.pesel != null) || (this.pesel != null && !this.pesel.equals(other.pesel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Wiezniowie[ pesel=" + pesel + " ]";
    }
    
}
