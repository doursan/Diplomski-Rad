/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Dusan
 */
@Embeddable
public class Child1PK implements Serializable {

    @Column(name = "id")
    private int id;
    @Column(name = "parent_id")
    private int parentId;

    public Child1PK() {
    }

    public Child1PK(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) parentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Child1PK)) {
            return false;
        }
        Child1PK other = (Child1PK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.parentId != other.parentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Child1PK[ id=" + id + ", parentId=" + parentId + " ]";
    }
    
}
