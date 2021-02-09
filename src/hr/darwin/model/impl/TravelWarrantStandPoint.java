/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.model.impl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darwin
 */
@Entity
@Table(name = "TravelWarrantStandPoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TravelWarrantStandPoint.findAll", query = "SELECT t FROM TravelWarrantStandPoint t")
    , @NamedQuery(name = "TravelWarrantStandPoint.findByIDStandPoint", query = "SELECT t FROM TravelWarrantStandPoint t WHERE t.iDStandPoint = :iDStandPoint")
    , @NamedQuery(name = "TravelWarrantStandPoint.findByTitle", query = "SELECT t FROM TravelWarrantStandPoint t WHERE t.title = :title")
    , @NamedQuery(name = "TravelWarrantStandPoint.findByCordinate", query = "SELECT t FROM TravelWarrantStandPoint t WHERE t.cordinate = :cordinate")
    , @NamedQuery(name = "TravelWarrantStandPoint.findByActive", query = "SELECT t FROM TravelWarrantStandPoint t WHERE t.active = :active")})
public class TravelWarrantStandPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDStandPoint")
    private Integer iDStandPoint;
    @Column(name = "Title")
    private String title;
    @Column(name = "Cordinate")
    private String cordinate;
    @Column(name = "Active")
    private Boolean active;
    @JoinColumn(name = "TravelWarrantID", referencedColumnName = "IDTravelWarrant")
    @ManyToOne
    private TravelWarrant travelWarrantID;

    public TravelWarrantStandPoint() {
    }

    public TravelWarrantStandPoint(Integer iDStandPoint) {
        this.iDStandPoint = iDStandPoint;
    }

    public Integer getIDStandPoint() {
        return iDStandPoint;
    }

    public void setIDStandPoint(Integer iDStandPoint) {
        this.iDStandPoint = iDStandPoint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCordinate() {
        return cordinate;
    }

    public void setCordinate(String cordinate) {
        this.cordinate = cordinate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public TravelWarrant getTravelWarrantID() {
        return travelWarrantID;
    }

    public void setTravelWarrantID(TravelWarrant travelWarrantID) {
        this.travelWarrantID = travelWarrantID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDStandPoint != null ? iDStandPoint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravelWarrantStandPoint)) {
            return false;
        }
        TravelWarrantStandPoint other = (TravelWarrantStandPoint) object;
        if ((this.iDStandPoint == null && other.iDStandPoint != null) || (this.iDStandPoint != null && !this.iDStandPoint.equals(other.iDStandPoint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.darwin.TravelWarrantStandPoint[ iDStandPoint=" + iDStandPoint + " ]";
    }
    
}
