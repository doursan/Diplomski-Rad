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
@Table(name = "parent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parent.findAll", query = "SELECT p FROM Parent p")
    , @NamedQuery(name = "Parent.findByParentId", query = "SELECT p FROM Parent p WHERE p.parentId = :parentId")
    , @NamedQuery(name = "Parent.findByParentName", query = "SELECT p FROM Parent p WHERE p.parentName = :parentName")})
public class Parent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "parent_name")
    private String parentName;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "parent")
    private List<Child> childList = new ArrayList<>();

    public Parent() {
    }

    public Parent(Integer parentId) {
        this.parentId = parentId;
    }

    public Parent(String parentName) {
        this.parentName = parentName;
    }
    
    public void addChild(Child child) {
        childList.add(child);
        child.setParent(this);
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @XmlTransient
    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentId != null ? parentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parent)) {
            return false;
        }
        Parent other = (Parent) object;
        if ((this.parentId == null && other.parentId != null) || (this.parentId != null && !this.parentId.equals(other.parentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Parent[ parentId=" + parentId + " ]";
    }
    
}
