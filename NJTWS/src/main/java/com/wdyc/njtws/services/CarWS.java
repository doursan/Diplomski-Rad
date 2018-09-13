/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.services;

import com.wdyc.njtws.dao.CarBrandDAO;
import com.wdyc.njtws.dao.CarDAO;
import com.wdyc.njtws.dao.EngineDAO;
import com.wdyc.njtws.domen.CarBrandEntity;
import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.domen.EngineEntity;
import com.wdyc.njtws.dto.CarBrandDTO;
import com.wdyc.njtws.dto.CarDTO;
import com.wdyc.njtws.dto.EngineDTO;
import com.wdyc.njtws.mapstruct.CarBrandMapper;
import com.wdyc.njtws.mapstruct.CarBrandModelMapper;
import com.wdyc.njtws.mapstruct.CarMapper;
import com.wdyc.njtws.mapstruct.EngineMapper;
import com.wdyc.njtws.mapstruct.impl.CarBrandMapperImpl;
import com.wdyc.njtws.mapstruct.impl.CarBrandModelMapperImpl;
import com.wdyc.njtws.mapstruct.impl.CarMapperImpl;
import com.wdyc.njtws.mapstruct.impl.EngineMapperImpl;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dusan
 */
@WebService(serviceName = "CarWS")
public class CarWS {

    CarMapper carMapper = new CarMapperImpl();
    CarBrandMapper carBrandMapper = new CarBrandMapperImpl();
    CarBrandModelMapper carBrandModelMapper = new CarBrandModelMapperImpl();
    EngineMapper engineMapper = new EngineMapperImpl();
    
    CarBrandDAO carBrandDao = new CarBrandDAO();
    EngineDAO engineDao = new EngineDAO();
    CarDAO carDao = new CarDAO();
    
   
    @WebMethod(operationName = "addCar")
    public CarDTO addCar() throws Exception {
        System.out.println("Calling add car from CarWS");
        
        List<CarBrandEntity> retrievedCarBrands = carBrandDao.retrieveAllCarBrands();
        List<EngineEntity> retrievedEngines = engineDao.retrieveAllEngines();  
        List<CarBrandDTO> convertedBrands = new ArrayList<>();
        List<EngineDTO> convertedEngines = new ArrayList<>();
        
        for(CarBrandEntity brand : retrievedCarBrands) {
            CarBrandDTO brandDto = carBrandMapper.carBrandEntityToDto(brand);
            convertedBrands.add(brandDto);
        }
        
        for(EngineEntity engine : retrievedEngines) {
            EngineDTO engineDto = engineMapper.engineEntityToDto(engine);
            convertedEngines.add(engineDto);
        }
        
        CarDTO car = new CarDTO();
        car.setBrands(convertedBrands);
        car.setEngines(convertedEngines);
        
        return car;
        
    }
    
    @WebMethod(operationName = "saveCar")
    public CarDTO saveCar(@WebParam(name = "car") CarDTO car) throws Exception {
        System.out.println("Calling save car from CarWS");  
        
        CarEntity convertedCar = carMapper.carDtoToEntity(car);
        CarEntity savedCar = carDao.saveCar(convertedCar);
        return carMapper.carEntityToDto(savedCar);
    }
}
