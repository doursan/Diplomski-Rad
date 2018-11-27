/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dto;

/**
 *
 * @author Dusan
 */
public class ItemDTO {
    
    private String amount;
    private String price;
    private CarPartDTO carPart;
    private ServiceDTO service;
    private int repairId;
    private int rowNumber;

    public ItemDTO() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CarPartDTO getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPartDTO carPart) {
        this.carPart = carPart;
    }

    public ServiceDTO getService() {
        return service;
    }

    public void setService(ServiceDTO service) {
        this.service = service;
    }   

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

}
