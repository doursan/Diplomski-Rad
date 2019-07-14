/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.CarEntity;
import com.wdyc.njtrestws.dto.CarDTO;
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
    @Mapping(target = "repairList", ignore = true)
    CarDTO carEntityToDto(CarEntity car);    
    
    @Mapping(target = "repairList", ignore = true)
    CarEntity carDtoToEntity(CarDTO car);
}
