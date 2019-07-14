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

    private int id;
    private int repair;

    public ItemEntityPK() {
    }

    public ItemEntityPK(int id, int repair) {
        this.id = id;
        this.repair = repair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRepair() {
        return repair;
    }

    public void setRepair(int repair) {
        this.repair = repair;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) repair;
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
        if (this.repair != other.repair) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wdyc.njtrestws.domen.ItemEntityPK[ id=" + id + ", repairId=" + repair + " ]";
    }
    
}
