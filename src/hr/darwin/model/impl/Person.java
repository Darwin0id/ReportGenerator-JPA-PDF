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
@Table(name = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByIDPerson", query = "SELECT p FROM Person p WHERE p.iDPerson = :iDPerson")
    , @NamedQuery(name = "Person.findByFName", query = "SELECT p FROM Person p WHERE p.fName = :fName")
    , @NamedQuery(name = "Person.findByLname", query = "SELECT p FROM Person p WHERE p.lname = :lname")
    , @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone")
    , @NamedQuery(name = "Person.findByDriverLicenseID", query = "SELECT p FROM Person p WHERE p.driverLicenseID = :driverLicenseID")
    , @NamedQuery(name = "Person.findByActive", query = "SELECT p FROM Person p WHERE p.active = :active")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPerson")
    private Integer iDPerson;
    @Basic(optional = false)
    @Column(name = "FName")
    private String fName;
    @Basic(optional = false)
    @Column(name = "Lname")
    private String lname;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "DriverLicenseID")
    private String driverLicenseID;
    @Basic(optional = false)
    @Column(name = "Active")
    private boolean active;
    @OneToMany(mappedBy = "personID")
    private Collection<TravelWarrant> travelWarrantCollection;

    public Person() {
    }

    public Person(Integer iDPerson) {
        this.iDPerson = iDPerson;
    }

    public Person(Integer iDPerson, String fName, String lname, String phone, String driverLicenseID, boolean active) {
        this.iDPerson = iDPerson;
        this.fName = fName;
        this.lname = lname;
        this.phone = phone;
        this.driverLicenseID = driverLicenseID;
        this.active = active;
    }

    public Integer getIDPerson() {
        return iDPerson;
    }

    public void setIDPerson(Integer iDPerson) {
        this.iDPerson = iDPerson;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriverLicenseID() {
        return driverLicenseID;
    }

    public void setDriverLicenseID(String driverLicenseID) {
        this.driverLicenseID = driverLicenseID;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        hash += (iDPerson != null ? iDPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.iDPerson == null && other.iDPerson != null) || (this.iDPerson != null && !this.iDPerson.equals(other.iDPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.darwin.Person[ iDPerson=" + iDPerson + " ]";
    }
    
}
