/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dusan
 */
@XmlRootElement
public class ClientDTO extends UserDTO {
    
    
    private String ime;
    private String prezime;
    private String jmbg;
    private List<CarDTO> carList;
    
    public ClientDTO() {
    }

    public ClientDTO(String ime, String prezime, String jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
    }

    public ClientDTO(String ime, String prezime, String jmbg, String username, String password) {
        super(username, password);
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
    }

    public ClientDTO(String ime, String prezime, String jmbg, String username, String password, String email) {
        super(username, password, email);
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

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

    public List<CarDTO> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDTO> carList) {
        this.carList = carList;
    }
}
