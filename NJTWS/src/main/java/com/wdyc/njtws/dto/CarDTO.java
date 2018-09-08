/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.dto;

import java.io.Serializable;

/**
 *
 * @author Dusan
 */
public class CarDTO implements Serializable {
    
    private String vin;
    private String registration;
    private String productionYear;
    private ClientDTO client;
    private EngineDTO engine;
    private CarBrandModelDTO brandModel;

    public CarDTO() {
    }

    public CarDTO(String registration, String productionYear, ClientDTO client, EngineDTO engine, CarBrandModelDTO brandModel) {
        this.registration = registration;
        this.productionYear = productionYear;
        this.client = client;
        this.engine = engine;
        this.brandModel = brandModel;
    }

    public CarDTO(String vin, String registration, String productionYear, ClientDTO client, EngineDTO engine, CarBrandModelDTO brandModel) {
        this.vin = vin;
        this.registration = registration;
        this.productionYear = productionYear;
        this.client = client;
        this.engine = engine;
        this.brandModel = brandModel;
    }

    public CarBrandModelDTO getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(CarBrandModelDTO brandModel) {
        this.brandModel = brandModel;
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

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public EngineDTO getEngine() {
        return engine;
    }

    public void setEngine(EngineDTO engine) {
        this.engine = engine;
    }
}
