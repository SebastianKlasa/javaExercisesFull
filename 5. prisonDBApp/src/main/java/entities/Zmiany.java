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
@Table(name = "zmiany")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zmiany.findAll", query = "SELECT z FROM Zmiany z")
    , @NamedQuery(name = "Zmiany.findById", query = "SELECT z FROM Zmiany z WHERE z.id = :id")
    , @NamedQuery(name = "Zmiany.findByData", query = "SELECT z FROM Zmiany z WHERE z.data = :data")
    , @NamedQuery(name = "Zmiany.findByGodzinaRozpoczecia", query = "SELECT z FROM Zmiany z WHERE z.godzinaRozpoczecia = :godzinaRozpoczecia")
    , @NamedQuery(name = "Zmiany.findByGodzinaZakonczenia", query = "SELECT z FROM Zmiany z WHERE z.godzinaZakonczenia = :godzinaZakonczenia")
    , @NamedQuery(name = "Zmiany.findByIdStraznik", query = "SELECT z FROM Zmiany z WHERE z.idStraznik = :idStraznik")
    , @NamedQuery(name = "Zmiany.findByIdSektor", query = "SELECT z FROM Zmiany z WHERE z.idSektor = :idSektor")})
public class Zmiany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "id_straznik")
    private String idStraznik;
    @Column(name = "id_sektor")
    private Character idSektor;

    public Zmiany() {
    }

    public Zmiany(Integer id) {
        this.id = id;
    }

    public Zmiany(Integer id, Date data, Date godzinaRozpoczecia, Date godzinaZakonczenia) {
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

    public String getIdStraznik() {
        return idStraznik;
    }

    public void setIdStraznik(String idStraznik) {
        this.idStraznik = idStraznik;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zmiany)) {
            return false;
        }
        Zmiany other = (Zmiany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Zmiany[ id=" + id + " ]";
    }
    
}
