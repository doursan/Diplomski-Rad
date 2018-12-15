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
public class Child2PK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "parent2_id")
    private int parent2;

    public Child2PK() {
    }

    public Child2PK(int id, int parent2) {
        this.id = id;
        this.parent2 = parent2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent2() {
        return parent2;
    }

    public void setParent2(int parent2) {
        this.parent2 = parent2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) parent2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Child2PK)) {
            return false;
        }
        Child2PK other = (Child2PK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.parent2 != other.parent2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Child2PK[ id=" + id + ", parent2Id=" + parent2 + " ]";
    }
    
}
