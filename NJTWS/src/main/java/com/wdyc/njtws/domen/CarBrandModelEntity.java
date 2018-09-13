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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "car_brand_model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarBrandModelEntity.findAll", query = "SELECT c FROM CarBrandModelEntity c")
    , @NamedQuery(name = "CarBrandModelEntity.findById", query = "SELECT c FROM CarBrandModelEntity c WHERE c.id = :id")
    , @NamedQuery(name = "CarBrandModelEntity.findByName", query = "SELECT c FROM CarBrandModelEntity c WHERE c.name = :name")
    , @NamedQuery(name = "CarBrandModelEntity.findByProductionBegan", query = "SELECT c FROM CarBrandModelEntity c WHERE c.productionBegan = :productionBegan")
    , @NamedQuery(name = "CarBrandModelEntity.findByProductionEnd", query = "SELECT c FROM CarBrandModelEntity c WHERE c.productionEnd = :productionEnd")})
public class CarBrandModelEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Column(name = "production_began")
    private Short productionBegan;
    @Column(name = "production_end")
    private Short productionEnd;
    @JoinColumn(name = "carbrand_id")
    @ManyToOne
    private CarBrandEntity carBrand;
    @OneToMany(mappedBy = "model")
    private List<ModelEngineEntity> modelEngineList;

    public CarBrandModelEntity() {
    }

    public CarBrandModelEntity(Integer id) {
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

    public Short getProductionBegan() {
        return productionBegan;
    }

    public void setProductionBegan(Short productionBegan) {
        this.productionBegan = productionBegan;
    }

    public Short getProductionEnd() {
        return productionEnd;
    }

    public void setProductionEnd(Short productionEnd) {
        this.productionEnd = productionEnd;
    }
   
    public CarBrandEntity getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrandEntity carBrand) {
        this.carBrand = carBrand;
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
        if (!(object instanceof CarBrandModelEntity)) {
            return false;
        }
        CarBrandModelEntity other = (CarBrandModelEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtws.domen.CarBrandModelEntity[ id=" + id + " ]";
    }

    @XmlTransient
    public List<ModelEngineEntity> getModelEngineList() {
        return modelEngineList;
    }

    public void setModelEngineList(List<ModelEngineEntity> modelEngineList) {
        this.modelEngineList = modelEngineList;
    }

}
