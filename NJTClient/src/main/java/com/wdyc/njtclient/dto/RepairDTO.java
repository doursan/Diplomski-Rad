/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dusan
 */
public class RepairDTO {

    private String id;
    private Date datum;
    private String kilometers;
    private boolean isActive;
    private String price;
    private CarDTO car;
    private UserDTO shop;
    private List<ItemDTO> itemList = new ArrayList<>();

    public RepairDTO() {
    }

    public RepairDTO(Date datum, String kilometers, boolean isActive, String price, CarDTO car, ShopDTO shop, List<ItemDTO> itemList) {
        this.datum = datum;
        this.kilometers = kilometers;
        this.isActive = isActive;
        this.price = price;
        this.car = car;
        this.shop = shop;
        this.itemList = itemList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public UserDTO getShop() {
        return shop;
    }

    public void setShop(UserDTO shop) {
        this.shop = shop;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }
    
    public void addItemToList(ItemDTO item) {
        itemList.add(item);
    }
}
