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
@Table(name = "odwiedziny")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odwiedziny.findAll", query = "SELECT o FROM Odwiedziny o")
    , @NamedQuery(name = "Odwiedziny.findById", query = "SELECT o FROM Odwiedziny o WHERE o.id = :id")
    , @NamedQuery(name = "Odwiedziny.findByData", query = "SELECT o FROM Odwiedziny o WHERE o.data = :data")
    , @NamedQuery(name = "Odwiedziny.findByGodzinaRozpoczecia", query = "SELECT o FROM Odwiedziny o WHERE o.godzinaRozpoczecia = :godzinaRozpoczecia")
    , @NamedQuery(name = "Odwiedziny.findByGodzinaZakonczenia", query = "SELECT o FROM Odwiedziny o WHERE o.godzinaZakonczenia = :godzinaZakonczenia")
    , @NamedQuery(name = "Odwiedziny.findByIdWiezien", query = "SELECT o FROM Odwiedziny o WHERE o.idWiezien = :idWiezien")})
public class Odwiedziny implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "godzina_rozpoczecia")
    @Temporal(TemporalType.TIME)
    private Date godzinaRozpoczecia;
    @Basic(optional = false)
    @Column(name = "godzina_zakonczenia")
    @Temporal(TemporalType.TIME)
    private Date godzinaZakonczenia;
    @Column(name = "id_wiezien")
    private String idWiezien;

    public Odwiedziny() {
    }

    public Odwiedziny(Integer id) {
        this.id = id;
    }

    public Odwiedziny(Integer id, Date data, Date godzinaRozpoczecia, Date godzinaZakonczenia) {
        this.id = id;
        this.data = data;
        this.godzinaRozpoczecia = godzinaRozpoczecia;
        this.godzinaZakonczenia = godzinaZakonczenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof Odwiedziny)) {
            return false;
        }
        Odwiedziny other = (Odwiedziny) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Odwiedziny[ id=" + id + " ]";
    }
    
}
