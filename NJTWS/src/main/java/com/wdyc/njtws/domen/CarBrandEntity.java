/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dusan
 */
@Entity
@Table(name = "car_brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarBrandEntity.findAll", query = "SELECT c FROM CarBrandEntity c")
    , @NamedQuery(name = "CarBrandEntity.findById", query = "SELECT c FROM CarBrandEntity c WHERE c.id = :id")
    , @NamedQuery(name = "CarBrandEntity.findByName", query = "SELECT c FROM CarBrandEntity c WHERE c.name = :name")
    , @NamedQuery(name = "CarBrandEntity.findByCountry", query = "SELECT c FROM CarBrandEntity c WHERE c.country = :country")})
public class CarBrandEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @OneToMany(mappedBy = "carBrand")
    private List<CarBrandModelEntity> carBrandModelList;

    public CarBrandEntity() {
    }

    public CarBrandEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlTransient
    public List<CarBrandModelEntity> getCarBrandModelList() {
        return carBrandModelList;
    }

    public void setCarBrandModelList(List<CarBrandModelEntity> carBrandModelList) {
        this.carBrandModelList = carBrandModelList;
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
        if (!(object instanceof CarBrandEntity)) {
            return false;
        }
        CarBrandEntity other = (CarBrandEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtws.domen.CarBrandEntity[ id=" + id + " ]";
    }
    
}
