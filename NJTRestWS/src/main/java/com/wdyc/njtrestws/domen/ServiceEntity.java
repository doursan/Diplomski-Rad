/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.domen;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dusan
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceEntity.findAll", query = "SELECT s FROM ServiceEntity s")
    , @NamedQuery(name = "ServiceEntity.findById", query = "SELECT s FROM ServiceEntity s WHERE s.id = :id")
    , @NamedQuery(name = "ServiceEntity.findByHours", query = "SELECT s FROM ServiceEntity s WHERE s.hours = :hours")
    , @NamedQuery(name = "ServiceEntity.findByPrice", query = "SELECT s FROM ServiceEntity s WHERE s.price = :price")
    , @NamedQuery(name = "ServiceEntity.findByName", query = "SELECT s FROM ServiceEntity s WHERE s.name = :name")})
public class ServiceEntity implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hours")
    private double hours;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "service")
    private List<ItemEntity> itemList;

    public ServiceEntity() {
    }

    public ServiceEntity(Integer id) {
        this.id = id;
    }

    public ServiceEntity(Integer id, int hours) {
        this.id = id;
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<ItemEntity> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemEntity> itemList) {
        this.itemList = itemList;
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
        if (!(object instanceof ServiceEntity)) {
            return false;
        }
        ServiceEntity other = (ServiceEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtrestws.domen.ServiceEntity[ id=" + id + " ]";
    }
    
}
