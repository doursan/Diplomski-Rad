/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dusan
 */
@XmlRootElement
public class ShopDTO extends UserDTO {

    private String naziv;
    private String pib;
    private String maticni;
    private List<RepairDTO> repairList;

    public ShopDTO() {
    }

    public ShopDTO(String naziv, String pib, String maticni) {
        this.naziv = naziv;
        this.pib = pib;
        this.maticni = maticni;
    }

    public ShopDTO(String naziv, String pib, String maticni, String username, String password, String email) {
        super(username, password, email);
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

    public List<RepairDTO> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<RepairDTO> repairList) {
        this.repairList = repairList;
    }
    
}
