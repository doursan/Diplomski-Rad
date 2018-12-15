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
@Table(name = "parent1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parent1.findAll", query = "SELECT p FROM Parent1 p")
    , @NamedQuery(name = "Parent1.findById", query = "SELECT p FROM Parent1 p WHERE p.id = :id")
    , @NamedQuery(name = "Parent1.findByName", query = "SELECT p FROM Parent1 p WHERE p.name = :name")})
public class Parent1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent1")
    private List<Child1> child1List = new ArrayList<>();

    public Parent1() {
    }

    public Parent1(String name) {
        this.name = name;
    }
    
    public Parent1(Integer id) {
        this.id = id;
    }

    public void addChild(Child1 child) {
        child1List.add(child);
        child.setParent1(this);
    }
    
    public Integer getId() {
        return id;
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
    public List<Child1> getChild1List() {
        return child1List;
    }

    public void setChild1List(List<Child1> child1List) {
        this.child1List = child1List;
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
        if (!(object instanceof Parent1)) {
            return false;
        }
        Parent1 other = (Parent1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Parent1[ id=" + id + " ]";
    }
    
}
