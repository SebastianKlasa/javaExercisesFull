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
@Table(name = "przepustki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Przepustki.findAll", query = "SELECT p FROM Przepustki p")
    , @NamedQuery(name = "Przepustki.findById", query = "SELECT p FROM Przepustki p WHERE p.id = :id")
    , @NamedQuery(name = "Przepustki.findByDataRozpoczecia", query = "SELECT p FROM Przepustki p WHERE p.dataRozpoczecia = :dataRozpoczecia")
    , @NamedQuery(name = "Przepustki.findByDataZakonczenia", query = "SELECT p FROM Przepustki p WHERE p.dataZakonczenia = :dataZakonczenia")
    , @NamedQuery(name = "Przepustki.findByPowod", query = "SELECT p FROM Przepustki p WHERE p.powod = :powod")
    , @NamedQuery(name = "Przepustki.findByIdWiezien", query = "SELECT p FROM Przepustki p WHERE p.idWiezien = :idWiezien")})
public class Przepustki implements Serializable {

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
    @Column(name = "powod")
    private String powod;
    @Column(name = "id_wiezien")
    private String idWiezien;

    public Przepustki() {
    }

    public Przepustki(Integer id) {
        this.id = id;
    }

    public Przepustki(Integer id, Date dataRozpoczecia, Date dataZakonczenia, String powod) {
        this.id = id;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.powod = powod;
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

    public String getPowod() {
        return powod;
    }

    public void setPowod(String powod) {
        this.powod = powod;
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
        if (!(object instanceof Przepustki)) {
            return false;
        }
        Przepustki other = (Przepustki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Przepustki[ id=" + id + " ]";
    }
    
}
