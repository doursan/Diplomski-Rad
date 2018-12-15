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
@Table(name = "guide")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guide.findAll", query = "SELECT g FROM Guide g")
    , @NamedQuery(name = "Guide.findById", query = "SELECT g FROM Guide g WHERE g.id = :id")
    , @NamedQuery(name = "Guide.findByName", query = "SELECT g FROM Guide g WHERE g.name = :name")
    , @NamedQuery(name = "Guide.findBySalary", query = "SELECT g FROM Guide g WHERE g.salary = :salary")
    , @NamedQuery(name = "Guide.findByStaffId", query = "SELECT g FROM Guide g WHERE g.staffId = :staffId")})
public class Guide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "staff_id")
    private String staffId;
    @OneToMany(mappedBy = "guide", cascade = {CascadeType.PERSIST})
    private List<Student> studentList = new ArrayList<>();

    public Guide() {
    }

    public Guide(Long id) {
        this.id = id;
    }

    public Guide(String name, Integer salary, String staffId) {
        this.name = name;
        this.salary = salary;
        this.staffId = staffId;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        student.setGuide(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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
        if (!(object instanceof Guide)) {
            return false;
        }
        Guide other = (Guide) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Guide[ id=" + id + " ]";
    }
    
}
