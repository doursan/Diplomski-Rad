/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.CarBrandEntity;
import com.wdyc.njtrestws.dto.CarBrandDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper(uses = CarBrandModelMapper.class)
public interface CarBrandMapper {
   
    CarBrandDTO carBrandEntityToDto(CarBrandEntity carBrand);
    
    CarBrandEntity carBrandDtoToEntity(CarBrandDTO carBrand);
}
