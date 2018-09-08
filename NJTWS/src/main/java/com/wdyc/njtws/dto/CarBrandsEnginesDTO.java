/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dusan
 */
public class CarBrandsEnginesDTO implements Serializable {
    
    private List<EngineDTO> engines = new ArrayList<>();
    private List<CarBrandDTO> carBrands = new ArrayList<>();

    public CarBrandsEnginesDTO() {
    }

    public List<EngineDTO> getEngines() {
        return engines;
    }

    public void setEngines(List<EngineDTO> engines) {
        this.engines = engines;
    }

    public List<CarBrandDTO> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(List<CarBrandDTO> carBrands) {
        this.carBrands = carBrands;
    }
    
    
}
