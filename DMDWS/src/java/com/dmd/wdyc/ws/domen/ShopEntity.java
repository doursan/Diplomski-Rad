/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmd.wdyc.ws.domen;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dusan
 */
@Entity
@DiscriminatorValue(value = "S")
public class ShopEntity extends UserEntity {
    
    private static final long serialVersionUID = 1L;

    public ShopEntity() {
    }

    @Size(max = 250)
    @Column(name = "naziv")
    private String naziv;
    @Size(max = 11)
    @Column(name = "pib")
    private String pib;
    @Size(max = 8)
    @Column(name = "maticni")
    private String maticni;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticni() {
        return maticni;
    }

    public void setMaticni(String maticni) {
        this.maticni = maticni;
    }

    public ShopEntity(String naziv, String pib, String maticni, String username, String password, String email) {
        super(username, password, email);
        this.naziv = naziv;
        this.pib = pib;
        this.maticni = maticni;
    }
    
}
