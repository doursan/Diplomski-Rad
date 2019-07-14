/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dusan
 */
public class ModelEngineDTO implements Serializable {
    
    private String id;
    private List<CarDTO> carEntityList;
    private EngineDTO engine;
    private CarBrandModelDTO model;

    public ModelEngineDTO() {
    }

    public ModelEngineDTO(List<CarDTO> carEntityList, EngineDTO engine, CarBrandModelDTO model) {
        this.id = id;
        this.carEntityList = carEntityList;
        this.engine = engine;
        this.model = model;
    }

    public ModelEngineDTO(String id, List<CarDTO> carEntityList, EngineDTO engine, CarBrandModelDTO model) {
        this.id = id;
        this.carEntityList = carEntityList;
        this.engine = engine;
        this.model = model;
    }

    public CarBrandModelDTO getModel() {
        return model;
    }

    public void setModel(CarBrandModelDTO model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CarDTO> getCarEntityList() {
        return carEntityList;
    }

    public void setCarEntityList(List<CarDTO> carEntityList) {
        this.carEntityList = carEntityList;
    }

    public EngineDTO getEngine() {
        return engine;
    }

    public void setEngine(EngineDTO engine) {
        this.engine = engine;
    }    
}
