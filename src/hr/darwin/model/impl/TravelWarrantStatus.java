/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.model.impl;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darwin
 */
@Entity
@Table(name = "TravelWarrantStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TravelWarrantStatus.findAll", query = "SELECT t FROM TravelWarrantStatus t")
    , @NamedQuery(name = "TravelWarrantStatus.findByIDStatus", query = "SELECT t FROM TravelWarrantStatus t WHERE t.iDStatus = :iDStatus")
    , @NamedQuery(name = "TravelWarrantStatus.findByTitle", query = "SELECT t FROM TravelWarrantStatus t WHERE t.title = :title")})
public class TravelWarrantStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDStatus")
    private Integer iDStatus;
    @Column(name = "Title")
    private String title;
    @OneToMany(mappedBy = "travelWarrantStatusID")
    private Collection<TravelWarrant> travelWarrantCollection;

    public TravelWarrantStatus() {
    }

    public TravelWarrantStatus(Integer iDStatus) {
        this.iDStatus = iDStatus;
    }

    public Integer getIDStatus() {
        return iDStatus;
    }

    public void setIDStatus(Integer iDStatus) {
        this.iDStatus = iDStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<TravelWarrant> getTravelWarrantCollection() {
        return travelWarrantCollection;
    }

    public void setTravelWarrantCollection(Collection<TravelWarrant> travelWarrantCollection) {
        this.travelWarrantCollection = travelWarrantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDStatus != null ? iDStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravelWarrantStatus)) {
            return false;
        }
        TravelWarrantStatus other = (TravelWarrantStatus) object;
        if ((this.iDStatus == null && other.iDStatus != null) || (this.iDStatus != null && !this.iDStatus.equals(other.iDStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.darwin.TravelWarrantStatus[ iDStatus=" + iDStatus + " ]";
    }
    
}
