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
public class CarDTO implements Serializable {

    private String id;
    private String vin;
    private String registration;
    private String productionYear;
    private ClientDTO owner;
    private ModelEngineDTO modelEngine;
    private List<EngineDTO> engines;
    private List<CarBrandDTO> brands;

    public CarDTO() {
    }

    public CarDTO(String vin, String registration, String productionYear, ClientDTO owner, ModelEngineDTO modelEngine) {
        this.vin = vin;
        this.registration = registration;
        this.productionYear = productionYear;
        this.owner = owner;
        this.modelEngine = modelEngine;
    }

    public CarDTO(String id, String vin, String registration, String productionYear, ClientDTO owner, ModelEngineDTO modelEngine) {
        this.id = id;
        this.vin = vin;
        this.registration = registration;
        this.productionYear = productionYear;
        this.owner = owner;
        this.modelEngine = modelEngine;
    }

    public CarDTO(String vin, String registration, String productionYear, ClientDTO owner, ModelEngineDTO modelEngine, List<EngineDTO> engines, List<CarBrandDTO> brands) {
        this.vin = vin;
        this.registration = registration;
        this.productionYear = productionYear;
        this.owner = owner;
        this.modelEngine = modelEngine;
        this.engines = engines;
        this.brands = brands;
    }

    public CarDTO(String id, String vin, String registration, String productionYear, ClientDTO owner, ModelEngineDTO modelEngine, List<EngineDTO> engines, List<CarBrandDTO> brands) {
        this.id = id;
        this.vin = vin;
        this.registration = registration;
        this.productionYear = productionYear;
        this.owner = owner;
        this.modelEngine = modelEngine;
        this.engines = engines;
        this.brands = brands;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public ClientDTO getOwner() {
        return owner;
    }

    public void setOwner(ClientDTO owner) {
        this.owner = owner;
    }

    public ModelEngineDTO getModelEngine() {
        return modelEngine;
    }

    public void setModelEngine(ModelEngineDTO modelEngine) {
        this.modelEngine = modelEngine;
    }

    public List<EngineDTO> getEngines() {
        return engines;
    }

    public void setEngines(List<EngineDTO> engines) {
        this.engines = engines;
    }

    public List<CarBrandDTO> getBrands() {
        return brands;
    }

    public void setBrands(List<CarBrandDTO> brands) {
        this.brands = brands;
    }
}
