/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.domen;

import com.wdyc.njtws.domen.CarBrandModelEntity;
import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.domen.EngineEntity;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dusan
 */
@Entity
@Table(name = "model_engine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelEngineEntity.findAll", query = "SELECT m FROM ModelEngineEntity m")
    , @NamedQuery(name = "ModelEngineEntity.findById", query = "SELECT m FROM ModelEngineEntity m WHERE m.id = :id")})
public class ModelEngineEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "modelEngine")
    private List<CarEntity> carEntityList;
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    @ManyToOne
    private EngineEntity engine;
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne
    private CarBrandModelEntity model;

    public ModelEngineEntity() {
    }

    public ModelEngineEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<CarEntity> getCarEntityList() {
        return carEntityList;
    }

    public void setCarEntityList(List<CarEntity> carEntityList) {
        this.carEntityList = carEntityList;
    }

    public EngineEntity getEngine() {
        return engine;
    }

    public void setEngine(EngineEntity engine) {
        this.engine = engine;
    }

    public CarBrandModelEntity getModel() {
        return model;
    }

    public void setModel(CarBrandModelEntity model) {
        this.model = model;
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
        if (!(object instanceof ModelEngineEntity)) {
            return false;
        }
        ModelEngineEntity other = (ModelEngineEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtws.dao.ModelEngineEntity[ id=" + id + " ]";
    }
    
}
