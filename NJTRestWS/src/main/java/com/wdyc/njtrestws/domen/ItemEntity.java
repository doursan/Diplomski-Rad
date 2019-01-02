/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.domen;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dusan
 */
@Entity
@IdClass(ItemEntityPK.class)
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemEntity.findAll", query = "SELECT i FROM ItemEntity i")
    , @NamedQuery(name = "ItemEntity.findById", query = "SELECT i FROM ItemEntity i WHERE i.id = :id")
    , @NamedQuery(name = "ItemEntity.findByRepairId", query = "SELECT i FROM ItemEntity i WHERE i.repair.id = :repairId")
    , @NamedQuery(name = "ItemEntity.findByAmount", query = "SELECT i FROM ItemEntity i WHERE i.amount = :amount")
    , @NamedQuery(name = "ItemEntity.findByPrice", query = "SELECT i FROM ItemEntity i WHERE i.price = :price")})
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private int id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "car_part_id", referencedColumnName = "id")
    @ManyToOne
    private CarPartEntity carPart;
    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "repair_id", referencedColumnName = "id")
    @Id
    private RepairEntity repair;
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    @ManyToOne
    private ServiceEntity service;

    public ItemEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarPartEntity getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPartEntity carPart) {
        this.carPart = carPart;
    }

    public RepairEntity getRepair() {
        return repair;
    }

    public void setRepair(RepairEntity repair) {
        this.repair = repair;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }
    
    @Override
    public String toString() {
        return "com.wdyc.njtrestws.domen.ItemEntity[ itemEntityPK=" + id + " ]";
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (this.repair.getId() != null ? this.repair.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntity)) {
            return false;
        }
        ItemEntity other = (ItemEntity) object;
        if (this.id != other.id) {
            return false;
        }
        if (!this.repair.equals(other.getRepair())) {
            return false;
        }
        return true;
    }
}
