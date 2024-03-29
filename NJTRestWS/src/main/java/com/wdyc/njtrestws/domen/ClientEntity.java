/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.domen;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dusan
 */
@Entity
@DiscriminatorValue(value = "C")
public class ClientEntity extends UserEntity {
    
    private static final long serialVersionUID = 1L;

    public ClientEntity() {
    }

    @Size(max = 30)
    @Column(name = "ime")
    private String ime;
    @Size(max = 50)
    @Column(name = "prezime")
    private String prezime;
    @Size(max = 13)
    @Column(name = "jmbg")
    private String jmbg;
    @OneToMany(mappedBy = "owner")
    private List<CarEntity> carList;

    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public ClientEntity(String ime, String prezime, String jmbg, String username, String password, String email) {
        super(username, password, email);
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
    }

    public ClientEntity(Integer id) {
        super(id);
    }

    public ClientEntity(Integer id, String username, String password, String email) {
        super(id, username, password, email);
    }       

    @XmlTransient
    public List<CarEntity> getCarList() {
        return carList;
    }

    public void setCarList(List<CarEntity> carList) {
        this.carList = carList;
    }    
}
