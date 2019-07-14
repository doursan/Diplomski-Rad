/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.dto;

import java.util.List;

/**
 *
 * @author Dusan
 */
public class ServiceDTO {
    
    private String id;
    private String hours;
    private String price;
    private String name;
    private List<ItemDTO> itemList;

    public ServiceDTO() {
    }

    public ServiceDTO(String hours, String price, String name) {
        this.hours = hours;
        this.price = price;
        this.name = name;
    }

    public ServiceDTO(String id, String hours, String price, String name) {
        this.id = id;
        this.hours = hours;
        this.price = price;
        this.name = name;
    }
       
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }
    
    
}
