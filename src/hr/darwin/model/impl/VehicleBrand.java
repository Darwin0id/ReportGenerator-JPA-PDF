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
@Table(name = "VehicleBrand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleBrand.findAll", query = "SELECT v FROM VehicleBrand v")
    , @NamedQuery(name = "VehicleBrand.findByIDBrand", query = "SELECT v FROM VehicleBrand v WHERE v.iDBrand = :iDBrand")
    , @NamedQuery(name = "VehicleBrand.findByTitle", query = "SELECT v FROM VehicleBrand v WHERE v.title = :title")})
public class VehicleBrand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDBrand")
    private Integer iDBrand;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @OneToMany(mappedBy = "brandID")
    private Collection<Vehicle> vehicleCollection;

    public VehicleBrand() {
    }

    public VehicleBrand(Integer iDBrand) {
        this.iDBrand = iDBrand;
    }

    public VehicleBrand(Integer iDBrand, String title) {
        this.iDBrand = iDBrand;
        this.title = title;
    }

    public Integer getIDBrand() {
        return iDBrand;
    }

    public void setIDBrand(Integer iDBrand) {
        this.iDBrand = iDBrand;
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
        hash += (iDBrand != null ? iDBrand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleBrand)) {
            return false;
        }
        VehicleBrand other = (VehicleBrand) object;
        if ((this.iDBrand == null && other.iDBrand != null) || (this.iDBrand != null && !this.iDBrand.equals(other.iDBrand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.darwin.VehicleBrand[ iDBrand=" + iDBrand + " ]";
    }
    
}
