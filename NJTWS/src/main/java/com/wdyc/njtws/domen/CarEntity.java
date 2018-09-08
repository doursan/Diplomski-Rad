/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.domen;

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
    , @NamedQuery(name = "CarEntity.findByVin", query = "SELECT c FROM CarEntity c WHERE c.vin = :vin")
    , @NamedQuery(name = "CarEntity.findByRegistration", query = "SELECT c FROM CarEntity c WHERE c.registration = :registration")
    , @NamedQuery(name = "CarEntity.findByProductionYear", query = "SELECT c FROM CarEntity c WHERE c.productionYear = :productionYear")})
public class CarEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "vin")
    private String vin;
    @Size(max = 15)
    @Column(name = "registration")
    private String registration;
    @Column(name = "production_year")
    private Short productionYear;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne
    private ClientEntity client;
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    @ManyToOne
    private EngineEntity engine;
    @JoinColumn(name = "brand_model_id", referencedColumnName = "id")
    @ManyToOne
    private CarBrandModelEntity brandModel;

    public CarEntity() {
    }

    public CarEntity(String vin) {
        this.vin = vin;
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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public EngineEntity getEngine() {
        return engine;
    }

    public void setEngine(EngineEntity engine) {
        this.engine = engine;
    }

    public CarBrandModelEntity getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(CarBrandModelEntity brandModel) {
        this.brandModel = brandModel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vin != null ? vin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarEntity)) {
            return false;
        }
        CarEntity other = (CarEntity) object;
        if ((this.vin == null && other.vin != null) || (this.vin != null && !this.vin.equals(other.vin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtws.domen.CarEntity[ vin=" + vin + " ]";
    }
    
}
