/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.domen;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dusan
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarEntity.findAll", query = "SELECT c FROM CarEntity c")
    , @NamedQuery(name = "CarEntity.findById", query = "SELECT c FROM CarEntity c WHERE c.id = :id")
    , @NamedQuery(name = "CarEntity.findByVin", query = "SELECT c FROM CarEntity c WHERE c.vin = :vin")
    , @NamedQuery(name = "CarEntity.findByRegistration", query = "SELECT c FROM CarEntity c WHERE c.registration = :registration")
    , @NamedQuery(name = "CarEntity.findByProductionYear", query = "SELECT c FROM CarEntity c WHERE c.productionYear = :productionYear")})
public class CarEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "vin")
    private String vin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "registration")
    private String registration;
    @Column(name = "production_year")
    private Short productionYear;
    @Column(name = "color")
    private String color;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne
    private ClientEntity owner;
    @JoinColumn(name = "model_engine_id", referencedColumnName = "id")
    @ManyToOne
    private ModelEngineEntity modelEngine;

    public CarEntity() {
    }

    public CarEntity(Integer id) {
        this.id = id;
    }

    public CarEntity(Integer id, String vin, String registration) {
        this.id = id;
        this.vin = vin;
        this.registration = registration;
    }

    public CarEntity(String vin, String registration, Short productionYear, ClientEntity owner, ModelEngineEntity modelEngine) {
        this.vin = vin;
        this.registration = registration;
        this.productionYear = productionYear;
        this.owner = owner;
        this.modelEngine = modelEngine;
    }

    public CarEntity(Integer id, String vin, String registration, Short productionYear, ClientEntity owner, ModelEngineEntity modelEngine) {
        this.id = id;
        this.vin = vin;
        this.registration = registration;
        this.productionYear = productionYear;
        this.owner = owner;
        this.modelEngine = modelEngine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Short getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Short productionYear) {
        this.productionYear = productionYear;
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
        if (!(object instanceof CarEntity)) {
            return false;
        }
        CarEntity other = (CarEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtws.domen.CarEntity[ id=" + id + " ]";
    }

    public ClientEntity getOwner() {
        return owner;
    }

    public void setOwner(ClientEntity owner) {
        this.owner = owner;
    }

    public ModelEngineEntity getModelEngine() {
        return modelEngine;
    }

    public void setModelEngine(ModelEngineEntity modelEngine) {
        this.modelEngine = modelEngine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
