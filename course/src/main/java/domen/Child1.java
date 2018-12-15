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
@Table(name = "child1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Child1.findAll", query = "SELECT c FROM Child1 c")
    , @NamedQuery(name = "Child1.findById", query = "SELECT c FROM Child1 c WHERE c.child1PK.id = :id")
    , @NamedQuery(name = "Child1.findByName", query = "SELECT c FROM Child1 c WHERE c.name = :name")
    , @NamedQuery(name = "Child1.findByParentId", query = "SELECT c FROM Child1 c WHERE c.child1PK.parentId = :parentId")})
public class Child1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Child1PK child1PK;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parent1 parent1;

    public Child1() {
    }

    public Child1(int id, String name) {
        child1PK = new Child1PK();
        child1PK.setId(id);
        this.name = name;
    }
    
    

    public Child1(Child1PK child1PK) {
        this.child1PK = child1PK;
    }

    public Child1(int id, int parentId) {
        this.child1PK = new Child1PK(id, parentId);
    }

    public Child1PK getChild1PK() {
        return child1PK;
    }

    public void setChild1PK(Child1PK child1PK) {
        this.child1PK = child1PK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent1 getParent1() {
        return parent1;
    }

    public void setParent1(Parent1 parent1) {
        this.parent1 = parent1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (child1PK != null ? child1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Child1)) {
            return false;
        }
        Child1 other = (Child1) object;
        if ((this.child1PK == null && other.child1PK != null) || (this.child1PK != null && !this.child1PK.equals(other.child1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Child1[ child1PK=" + child1PK + " ]";
    }
    
}
