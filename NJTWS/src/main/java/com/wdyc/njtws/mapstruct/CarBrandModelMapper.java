/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.CarBrandModelEntity;
import com.wdyc.njtws.dto.CarBrandModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper(uses = ModelEngineMapper.class)
public interface CarBrandModelMapper {
    
    @Mapping(target = "carBrand", ignore = true)
    CarBrandModelDTO carBrandModelEntityToDto(CarBrandModelEntity carBrandModel);
    
    CarBrandModelEntity carBrandModelDtoToEntity(CarBrandModelDTO carBrandModel);
}
