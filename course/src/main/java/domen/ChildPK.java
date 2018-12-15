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
public class ChildPK implements Serializable {

    private int childId;
    private int parent;

    public ChildPK() {
    }

    public ChildPK(int childId, int parent) {
        this.childId = childId;
        this.parent = parent;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) childId;
        hash += (int) parent;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChildPK)) {
            return false;
        }
        ChildPK other = (ChildPK) object;
        if (this.childId != other.childId) {
            return false;
        }
        if (this.parent != other.parent) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.ChildPK[ childId=" + childId + ", fkParentId=" + parent + " ]";
    }
    
}
