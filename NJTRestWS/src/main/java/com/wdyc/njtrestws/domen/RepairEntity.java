/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.domen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dusan
 */
@Entity
@Table(name = "repair")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepairEntity.findAll", query = "SELECT r FROM RepairEntity r")
    , @NamedQuery(name = "RepairEntity.findById", query = "SELECT r FROM RepairEntity r WHERE r.id = :id")
    , @NamedQuery(name = "RepairEntity.findByDate", query = "SELECT r FROM RepairEntity r WHERE r.datum = :datum")
    , @NamedQuery(name = "RepairEntity.findByKilometers", query = "SELECT r FROM RepairEntity r WHERE r.kilometers = :kilometers")
    , @NamedQuery(name = "RepairEntity.findByStatus", query = "SELECT r FROM RepairEntity r WHERE r.isActive = :isActive")
    , @NamedQuery(name = "RepairEntity.findByPrice", query = "SELECT r FROM RepairEntity r WHERE r.price = :price")})
public class RepairEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datum")
    private LocalDate datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kilometers")
    private int kilometers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @ManyToOne
    private CarEntity car;
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    @ManyToOne
    private UserEntity shop;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "repair", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<ItemEntity> itemList = new ArrayList<>();

    public RepairEntity() {
    }

    public RepairEntity(Integer id) {
        this.id = id;
    }

    public RepairEntity(Integer id, LocalDate datum, int kilometers, boolean isActive) {
        this.id = id;
        this.datum = datum;
        this.kilometers = kilometers;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
    

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public UserEntity getShop() {
        return shop;
    }

    public void setShop(UserEntity shop) {
        this.shop = shop;
    }

    @XmlTransient
    public List<ItemEntity> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemEntity> itemList) {
        this.itemList = itemList;
        for(ItemEntity item : this.itemList) {
            item.setRepair(this);
        }
    }
    
    public void addItem(ItemEntity item) {
        item.setRepair(this);
        itemList.add(item);
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
        if (!(object instanceof RepairEntity)) {
            return false;
        }
        RepairEntity other = (RepairEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtrestws.domen.RepairEntity[ id=" + id + " ]";
    }
    
}
