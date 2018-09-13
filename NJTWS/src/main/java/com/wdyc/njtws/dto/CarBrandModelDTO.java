/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.dto;

import java.io.Serializable;
import java.util.List;

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
    private List<ModelEngineDTO> modelEngineList;

    public CarBrandModelDTO() {
    }

    public CarBrandModelDTO(String name, String productionBegan, String productionEnd, CarBrandDTO carBrand, List<ModelEngineDTO> modelEngineList) {
        this.name = name;
        this.productionBegan = productionBegan;
        this.productionEnd = productionEnd;
        this.carBrand = carBrand;
        this.modelEngineList = modelEngineList;
    }

    public CarBrandModelDTO(String id, String name, String productionBegan, String productionEnd, CarBrandDTO carBrand, List<ModelEngineDTO> modelEngineList) {
        this.id = id;
        this.name = name;
        this.productionBegan = productionBegan;
        this.productionEnd = productionEnd;
        this.carBrand = carBrand;
        this.modelEngineList = modelEngineList;
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

    public List<ModelEngineDTO> getModelEngineList() {
        return modelEngineList;
    }

    public void setModelEngineList(List<ModelEngineDTO> modelEngineList) {
        this.modelEngineList = modelEngineList;
    }
}
