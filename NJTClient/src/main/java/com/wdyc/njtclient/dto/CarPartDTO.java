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
public class CarPartDTO {
    
    private String id;
    private String name;
    private String price;
    private List<ItemDTO> itemList;

    public CarPartDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }    

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return name;
    }   
    
}
