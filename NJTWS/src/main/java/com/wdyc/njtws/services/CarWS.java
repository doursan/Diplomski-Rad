/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.services;

import com.wdyc.njtws.dao.CarBrandDAO;
import com.wdyc.njtws.dao.EngineDAO;
import com.wdyc.njtws.domen.CarBrandEntity;
import com.wdyc.njtws.domen.CarBrandsEngines;
import com.wdyc.njtws.domen.EngineEntity;
import com.wdyc.njtws.dto.CarBrandsEnginesDTO;
import com.wdyc.njtws.mapstruct.CarBrandMapper;
import com.wdyc.njtws.mapstruct.CarBrandModelMapper;
import com.wdyc.njtws.mapstruct.CarBrandsEnginesMapper;
import com.wdyc.njtws.mapstruct.CarMapper;
import com.wdyc.njtws.mapstruct.EngineMapper;
import com.wdyc.njtws.mapstruct.impl.CarBrandMapperImpl;
import com.wdyc.njtws.mapstruct.impl.CarBrandModelMapperImpl;
import com.wdyc.njtws.mapstruct.impl.CarBrandsEnginesMapperImpl;
import com.wdyc.njtws.mapstruct.impl.CarMapperImpl;
import com.wdyc.njtws.mapstruct.impl.EngineMapperImpl;
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
    CarBrandsEnginesMapper cbeMapper= new CarBrandsEnginesMapperImpl();
    
    CarBrandDAO carBrandDao = new CarBrandDAO();
    EngineDAO engineDao = new EngineDAO();
    
    @WebMethod(operationName = "addCar")
    public CarBrandsEnginesDTO addCar() throws Exception {
        System.out.println("Calling add car from CarWS");
        
        List<CarBrandEntity> retrievedCarBrands = carBrandDao.retrieveAllCarBrands();
        List<EngineEntity> retrievedEngines = engineDao.retrieveAllEngines();        
        CarBrandsEngines cbe = new CarBrandsEngines(retrievedCarBrands, retrievedEngines);
        CarBrandsEnginesDTO cbeDto = cbeMapper.carBrandsEnginesToDto(cbe);
        return cbeDto;
        
    }
}
