/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.domen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dusan
 */
public class CarBrandsEngines {
    
    private List<CarBrandEntity> carBrands = new ArrayList<>();
    private List<EngineEntity> engines = new ArrayList<>();

    public CarBrandsEngines(List<CarBrandEntity> carBrands, List<EngineEntity> engines) {
        this.carBrands = carBrands;
        this.engines = engines;
    }

    public CarBrandsEngines() {
    }       
    
    public List<CarBrandEntity> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(List<CarBrandEntity> carBrands) {
        this.carBrands = carBrands;
    }

    public List<EngineEntity> getEngines() {
        return engines;
    }

    public void setEngines(List<EngineEntity> engines) {
        this.engines = engines;
    }
    
    
}
