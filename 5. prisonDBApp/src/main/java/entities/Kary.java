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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "kary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kary.findAll", query = "SELECT k FROM Kary k")
    , @NamedQuery(name = "Kary.findById", query = "SELECT k FROM Kary k WHERE k.id = :id")
    , @NamedQuery(name = "Kary.findByDataRozpoczecia", query = "SELECT k FROM Kary k WHERE k.dataRozpoczecia = :dataRozpoczecia")
    , @NamedQuery(name = "Kary.findByDataZakonczenia", query = "SELECT k FROM Kary k WHERE k.dataZakonczenia = :dataZakonczenia")
    , @NamedQuery(name = "Kary.findByPrzyczyna", query = "SELECT k FROM Kary k WHERE k.przyczyna = :przyczyna")
    , @NamedQuery(name = "Kary.findByRodzaj", query = "SELECT k FROM Kary k WHERE k.rodzaj = :rodzaj")
    , @NamedQuery(name = "Kary.findByMiejsce", query = "SELECT k FROM Kary k WHERE k.miejsce = :miejsce")
    , @NamedQuery(name = "Kary.findByIdWiezien", query = "SELECT k FROM Kary k WHERE k.idWiezien = :idWiezien")})
public class Kary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_rozpoczecia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRozpoczecia;
    @Basic(optional = false)
    @Column(name = "data_zakonczenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZakonczenia;
    @Basic(optional = false)
    @Column(name = "przyczyna")
    private String przyczyna;
    @Basic(optional = false)
    @Column(name = "rodzaj")
    private String rodzaj;
    @Basic(optional = false)
    @Column(name = "miejsce")
    private String miejsce;
    @Column(name = "id_wiezien")
    private String idWiezien;

    public Kary() {
    }

    public Kary(Integer id) {
        this.id = id;
    }

    public Kary(Integer id, Date dataRozpoczecia, Date dataZakonczenia, String przyczyna, String rodzaj, String miejsce) {
        this.id = id;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.przyczyna = przyczyna;
        this.rodzaj = rodzaj;
        this.miejsce = miejsce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public String getPrzyczyna() {
        return przyczyna;
    }

    public void setPrzyczyna(String przyczyna) {
        this.przyczyna = przyczyna;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public String getIdWiezien() {
        return idWiezien;
    }

    public void setIdWiezien(String idWiezien) {
        this.idWiezien = idWiezien;
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
        if (!(object instanceof Kary)) {
            return false;
        }
        Kary other = (Kary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Kary[ id=" + id + " ]";
    }
    
}
