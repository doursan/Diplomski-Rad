/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper(uses = {ModelEngineMapper.class, ClientMapper.class})
public interface CarMapper {
    
    @Mapping(target = "engines", ignore = true)
    @Mapping(target = "brands", ignore = true)
    CarDTO carEntityToDto(CarEntity car);    
    
    CarEntity carDtoToEntity(CarDTO car);
}
