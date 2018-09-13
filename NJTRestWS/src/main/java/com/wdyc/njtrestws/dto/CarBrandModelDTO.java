/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dto;

import java.io.Serializable;

/**
 *
 * @author Dusan
 */
public class CarBrandModelDTO implements Serializable {
    
    private String id;
    private String name;
    private String productionBegan;
    private String productionEnd;
    private CarBrandDTO carBrand;

    public CarBrandModelDTO() {
    }

    public CarBrandModelDTO(String name, String productionBegan, String productionEnd, CarBrandDTO carBrand) {
        this.name = name;
        this.productionBegan = productionBegan;
        this.productionEnd = productionEnd;
        this.carBrand = carBrand;
    }

    public CarBrandModelDTO(String id, String name, String productionBegan, String productionEnd, CarBrandDTO carBrand) {
        this.id = id;
        this.name = name;
        this.productionBegan = productionBegan;
        this.productionEnd = productionEnd;
        this.carBrand = carBrand;
    }

    public CarBrandDTO getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrandDTO carBrand) {
        this.carBrand = carBrand;
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

    public String getProductionBegan() {
        return productionBegan;
    }

    public void setProductionBegan(String productionBegan) {
        this.productionBegan = productionBegan;
    }

    public String getProductionEnd() {
        return productionEnd;
    }

    public void setProductionEnd(String productionEnd) {
        this.productionEnd = productionEnd;
    }
}
