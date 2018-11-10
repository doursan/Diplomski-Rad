/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dusan
 */
@Embeddable
public class ItemEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "repair_id")
    private int repairId;

    public ItemEntityPK() {
    }

    public ItemEntityPK(int id, int repairId) {
        this.id = id;
        this.repairId = repairId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) repairId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntityPK)) {
            return false;
        }
        ItemEntityPK other = (ItemEntityPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.repairId != other.repairId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtrestws.domen.ItemEntityPK[ id=" + id + ", repairId=" + repairId + " ]";
    }
    
}
