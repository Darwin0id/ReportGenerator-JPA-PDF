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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TravelWarrant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TravelWarrant.findAll", query = "SELECT t FROM TravelWarrant t")
    , @NamedQuery(name = "TravelWarrant.findByIDTravelWarrant", query = "SELECT t FROM TravelWarrant t WHERE t.iDTravelWarrant = :iDTravelWarrant")
    , @NamedQuery(name = "TravelWarrant.findByTripDuration", query = "SELECT t FROM TravelWarrant t WHERE t.tripDuration = :tripDuration")
    , @NamedQuery(name = "TravelWarrant.findByRoadDistance", query = "SELECT t FROM TravelWarrant t WHERE t.roadDistance = :roadDistance")
    , @NamedQuery(name = "TravelWarrant.findByFuelPrice", query = "SELECT t FROM TravelWarrant t WHERE t.fuelPrice = :fuelPrice")
    , @NamedQuery(name = "TravelWarrant.findByStartCordinate", query = "SELECT t FROM TravelWarrant t WHERE t.startCordinate = :startCordinate")
    , @NamedQuery(name = "TravelWarrant.findByStartAddress", query = "SELECT t FROM TravelWarrant t WHERE t.startAddress = :startAddress")
    , @NamedQuery(name = "TravelWarrant.findByEndCordinate", query = "SELECT t FROM TravelWarrant t WHERE t.endCordinate = :endCordinate")
    , @NamedQuery(name = "TravelWarrant.findByEndAddress", query = "SELECT t FROM TravelWarrant t WHERE t.endAddress = :endAddress")
    , @NamedQuery(name = "TravelWarrant.findByActive", query = "SELECT t FROM TravelWarrant t WHERE t.active = :active")})
public class TravelWarrant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTravelWarrant")
    private Integer iDTravelWarrant;
    @Column(name = "TripDuration")
    private String tripDuration;
    @Column(name = "RoadDistance")
    private String roadDistance;
    @Column(name = "FuelPrice")
    private String fuelPrice;
    @Column(name = "StartCordinate")
    private String startCordinate;
    @Column(name = "StartAddress")
    private String startAddress;
    @Column(name = "EndCordinate")
    private String endCordinate;
    @Column(name = "EndAddress")
    private String endAddress;
    @Column(name = "Active")
    private Boolean active;
    @OneToMany(mappedBy = "travelWarrantID")
    private Collection<TravelWarrantStandPoint> travelWarrantStandPointCollection;
    @JoinColumn(name = "PersonID", referencedColumnName = "IDPerson")
    @ManyToOne
    private Person personID;
    @JoinColumn(name = "TravelWarrantStatusID", referencedColumnName = "IDStatus")
    @ManyToOne
    private TravelWarrantStatus travelWarrantStatusID;
    @JoinColumn(name = "VehicleID", referencedColumnName = "IDVehicle")
    @ManyToOne
    private Vehicle vehicleID;

    public TravelWarrant() {
    }

    public TravelWarrant(Integer iDTravelWarrant) {
        this.iDTravelWarrant = iDTravelWarrant;
    }

    public Integer getIDTravelWarrant() {
        return iDTravelWarrant;
    }

    public void setIDTravelWarrant(Integer iDTravelWarrant) {
        this.iDTravelWarrant = iDTravelWarrant;
    }

    public String getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(String tripDuration) {
        this.tripDuration = tripDuration;
    }

    public String getRoadDistance() {
        return roadDistance;
    }

    public void setRoadDistance(String roadDistance) {
        this.roadDistance = roadDistance;
    }

    public String getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(String fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public String getStartCordinate() {
        return startCordinate;
    }

    public void setStartCordinate(String startCordinate) {
        this.startCordinate = startCordinate;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndCordinate() {
        return endCordinate;
    }

    public void setEndCordinate(String endCordinate) {
        this.endCordinate = endCordinate;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<TravelWarrantStandPoint> getTravelWarrantStandPointCollection() {
        return travelWarrantStandPointCollection;
    }

    public void setTravelWarrantStandPointCollection(Collection<TravelWarrantStandPoint> travelWarrantStandPointCollection) {
        this.travelWarrantStandPointCollection = travelWarrantStandPointCollection;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public TravelWarrantStatus getTravelWarrantStatusID() {
        return travelWarrantStatusID;
    }

    public void setTravelWarrantStatusID(TravelWarrantStatus travelWarrantStatusID) {
        this.travelWarrantStatusID = travelWarrantStatusID;
    }

    public Vehicle getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Vehicle vehicleID) {
        this.vehicleID = vehicleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTravelWarrant != null ? iDTravelWarrant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravelWarrant)) {
            return false;
        }
        TravelWarrant other = (TravelWarrant) object;
        if ((this.iDTravelWarrant == null && other.iDTravelWarrant != null) || (this.iDTravelWarrant != null && !this.iDTravelWarrant.equals(other.iDTravelWarrant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Izvještaj[iDTravelWarrant=" + iDTravelWarrant + " ]";
    }
    
}
