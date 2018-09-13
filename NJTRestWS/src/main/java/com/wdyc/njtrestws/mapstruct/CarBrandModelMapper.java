/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.CarBrandModelEntity;
import com.wdyc.njtrestws.dto.CarBrandModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper
public interface CarBrandModelMapper {
    @Mapping(target = "carBrand", ignore = true)
    CarBrandModelDTO carBrandModelEntityToDto(CarBrandModelEntity carBrandModel);
    
    @Mapping(target = "carList", ignore = true)
    CarBrandModelEntity carBrandModelDtoToEntity(CarBrandModelDTO carBrandModel);
}
