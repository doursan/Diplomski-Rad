/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.dto;

/**
 *
 * @author Dusan
 */
public class ShopDTO extends UserDTO {

    private String naziv;
    private String pib;
    private String maticni;

    public ShopDTO() {
    }

    public ShopDTO(String naziv, String pib, String maticni) {
        this.naziv = naziv;
        this.pib = pib;
        this.maticni = maticni;
    }

    public ShopDTO(String naziv, String pib, String maticni, String username, String password) {
        super(username, password);
        this.naziv = naziv;
        this.pib = pib;
        this.maticni = maticni;
    }

    public ShopDTO(String naziv, String pib, String maticni, String id, String username, String password, String email, String type) {
        super(id, username, password, email, type);
        this.naziv = naziv;
        this.pib = pib;
        this.maticni = maticni;
    }

    public String getMaticni() {
        return maticni;
    }

    public void setMaticni(String maticni) {
        this.maticni = maticni;
    }

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
}
