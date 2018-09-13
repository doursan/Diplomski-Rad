/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dusan
 */
public class CarBrandDTO implements Serializable {
    
    private String id;
    private String name;
    private String country;
    private List<CarBrandModelDTO> carBrandModelList;

    public CarBrandDTO() {
    }

    public CarBrandDTO(String name, String country, List<CarBrandModelDTO> carBrandModelList) {        
        this.name = name;
        this.country = country;
        this.carBrandModelList = carBrandModelList;
    }

    public CarBrandDTO(String id, String name, String country, List<CarBrandModelDTO> carBrandModelList) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.carBrandModelList = carBrandModelList;
    }
    
    public List<CarBrandModelDTO> getCarBrandModelList() {
        return carBrandModelList;
    }

    public void setCarBrandModelList(List<CarBrandModelDTO> carBrandModelList) {
        this.carBrandModelList = carBrandModelList;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    } 

    @Override
    public String toString() {
        return getName();
    }   
}
