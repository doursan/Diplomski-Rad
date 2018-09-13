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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dusan
 */
@Entity
@Table(name = "engine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngineEntity.findAll", query = "SELECT e FROM EngineEntity e")
    , @NamedQuery(name = "EngineEntity.findById", query = "SELECT e FROM EngineEntity e WHERE e.id = :id")
    , @NamedQuery(name = "EngineEntity.findByName", query = "SELECT e FROM EngineEntity e WHERE e.name = :name")
    , @NamedQuery(name = "EngineEntity.findByFuel", query = "SELECT e FROM EngineEntity e WHERE e.fuel = :fuel")
    , @NamedQuery(name = "EngineEntity.findByKw", query = "SELECT e FROM EngineEntity e WHERE e.kw = :kw")
    , @NamedQuery(name = "EngineEntity.findByHp", query = "SELECT e FROM EngineEntity e WHERE e.hp = :hp")
    , @NamedQuery(name = "EngineEntity.findByVolume", query = "SELECT e FROM EngineEntity e WHERE e.volume = :volume")})
public class EngineEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "name")
    private String name;
    @Size(max = 10)
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "kw")
    private Integer kw;
    @Column(name = "hp")
    private Integer hp;
    @Column(name = "volume")
    private Integer volume;
    @OneToMany(mappedBy = "engine")
    private List<CarEntity> carList;

    public EngineEntity() {
    }

    public EngineEntity(Integer id) {
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

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getKw() {
        return kw;
    }

    public void setKw(Integer kw) {
        this.kw = kw;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @XmlTransient
    public List<CarEntity> getCarEntityList() {
        return carList;
    }

    public void setCarEntityList(List<CarEntity> carEntityList) {
        this.carList = carEntityList;
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
        if (!(object instanceof EngineEntity)) {
            return false;
        }
        EngineEntity other = (EngineEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtws.domen.EngineEntity[ id=" + id + " ]";
    }
    
}
