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
@Table(name = "VehicleType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleType.findAll", query = "SELECT v FROM VehicleType v")
    , @NamedQuery(name = "VehicleType.findByIDType", query = "SELECT v FROM VehicleType v WHERE v.iDType = :iDType")
    , @NamedQuery(name = "VehicleType.findByTitle", query = "SELECT v FROM VehicleType v WHERE v.title = :title")})
public class VehicleType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDType")
    private Integer iDType;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @OneToMany(mappedBy = "typeID")
    private Collection<Vehicle> vehicleCollection;

    public VehicleType() {
    }

    public VehicleType(Integer iDType) {
        this.iDType = iDType;
    }

    public VehicleType(Integer iDType, String title) {
        this.iDType = iDType;
        this.title = title;
    }

    public Integer getIDType() {
        return iDType;
    }

    public void setIDType(Integer iDType) {
        this.iDType = iDType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDType != null ? iDType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleType)) {
            return false;
        }
        VehicleType other = (VehicleType) object;
        if ((this.iDType == null && other.iDType != null) || (this.iDType != null && !this.iDType.equals(other.iDType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.darwin.VehicleType[ iDType=" + iDType + " ]";
    }
    
}
