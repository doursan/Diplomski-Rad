/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "parent2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parent2.findAll", query = "SELECT p FROM Parent2 p")
    , @NamedQuery(name = "Parent2.findById", query = "SELECT p FROM Parent2 p WHERE p.id = :id")
    , @NamedQuery(name = "Parent2.findByName", query = "SELECT p FROM Parent2 p WHERE p.name = :name")})
public class Parent2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent2")
    private List<Child2> child2List = new ArrayList<>();

    public Parent2() {
    }
    
    public Parent2(Integer id) {
        this.id = id;
    }

    public Parent2(String name) {
        this.name = name;
    }
    

    public Integer getId() {
        return id;
    }

    public void addChild(Child2 child) {
        child2List.add(child);
        child.setParent2(this);
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

    @XmlTransient
    public List<Child2> getChild2List() {
        return child2List;
    }

    public void setChild2List(List<Child2> child2List) {
        this.child2List = child2List;
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
        if (!(object instanceof Parent2)) {
            return false;
        }
        Parent2 other = (Parent2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Parent2[ id=" + id + " ]";
    }
    
}
