/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dusan
 */
@Entity
@Table(name = "child2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Child2.findAll", query = "SELECT c FROM Child2 c")
    })
public class Child2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Child2PK child2PK;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "parent2_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parent2 parent2;

    public Child2() {
    }

    public Child2(Child2PK child2PK) {
        this.child2PK = child2PK;
    }

    public Child2(int id, String name) {
        child2PK = new Child2PK();
        child2PK.setId(id);
        this.name = name;
    }

    
    public Child2(int id, int parent2Id) {
        this.child2PK = new Child2PK(id, parent2Id);
    }

    public Child2PK getChild2PK() {
        return child2PK;
    }

    public void setChild2PK(Child2PK child2PK) {
        this.child2PK = child2PK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent2 getParent2() {
        return parent2;
    }

    public void setParent2(Parent2 parent2) {
        this.parent2 = parent2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (child2PK != null ? child2PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Child2)) {
            return false;
        }
        Child2 other = (Child2) object;
        if ((this.child2PK == null && other.child2PK != null) || (this.child2PK != null && !this.child2PK.equals(other.child2PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Child2[ child2PK=" + child2PK + " ]";
    }
    
}
