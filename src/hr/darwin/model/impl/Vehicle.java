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
@Table(name = "Vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findByIDVehicle", query = "SELECT v FROM Vehicle v WHERE v.iDVehicle = :iDVehicle")
    , @NamedQuery(name = "Vehicle.findByYearOfManufacture", query = "SELECT v FROM Vehicle v WHERE v.yearOfManufacture = :yearOfManufacture")
    , @NamedQuery(name = "Vehicle.findByStartingKM", query = "SELECT v FROM Vehicle v WHERE v.startingKM = :startingKM")
    , @NamedQuery(name = "Vehicle.findByActive", query = "SELECT v FROM Vehicle v WHERE v.active = :active")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDVehicle")
    private Integer iDVehicle;
    @Basic(optional = false)
    @Column(name = "YearOfManufacture")
    private int yearOfManufacture;
    @Basic(optional = false)
    @Column(name = "StartingKM")
    private int startingKM;
    @Column(name = "Active")
    private Boolean active;
    @JoinColumn(name = "BrandID", referencedColumnName = "IDBrand")
    @ManyToOne
    private VehicleBrand brandID;
    @JoinColumn(name = "TypeID", referencedColumnName = "IDType")
    @ManyToOne
    private VehicleType typeID;
    @OneToMany(mappedBy = "vehicleID")
    private Collection<TravelWarrant> travelWarrantCollection;

    public Vehicle() {
    }

    public Vehicle(Integer iDVehicle) {
        this.iDVehicle = iDVehicle;
    }

    public Vehicle(Integer iDVehicle, int yearOfManufacture, int startingKM) {
        this.iDVehicle = iDVehicle;
        this.yearOfManufacture = yearOfManufacture;
        this.startingKM = startingKM;
    }

    public Integer getIDVehicle() {
        return iDVehicle;
    }

    public void setIDVehicle(Integer iDVehicle) {
        this.iDVehicle = iDVehicle;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getStartingKM() {
        return startingKM;
    }

    public void setStartingKM(int startingKM) {
        this.startingKM = startingKM;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public VehicleBrand getBrandID() {
        return brandID;
    }

    public void setBrandID(VehicleBrand brandID) {
        this.brandID = brandID;
    }

    public VehicleType getTypeID() {
        return typeID;
    }

    public void setTypeID(VehicleType typeID) {
        this.typeID = typeID;
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
        hash += (iDVehicle != null ? iDVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.iDVehicle == null && other.iDVehicle != null) || (this.iDVehicle != null && !this.iDVehicle.equals(other.iDVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.darwin.Vehicle[ iDVehicle=" + iDVehicle + " ]";
    }
    
}
