/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(ChildPK.class)
@Table(name = "child")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Child.findAll", query = "SELECT c FROM Child c")})
public class Child implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "child_id")
    private int childId;
    @Column(name = "child_name")
    private String childName;
    @ManyToOne
    @Basic(optional = false)
    @Id
    @JoinColumn(name = "fk_parent_id", referencedColumnName = "parent_id")
    private Parent parent;

    public Child() {
    }

    public Child(int id, String childName) {
        this.childId = id;
        this.childName = childName;
    }   

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "domen.Child[ childPK=" + childId + " ]";
    }
    
}
