/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.dto.CarDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper(uses = {CarBrandModelMapper.class, EngineMapper.class, ClientMapper.class})
public interface CarMapper {
    
    CarDTO carEntityToDto(CarEntity car);    
    
    CarEntity carDtoToEntity(CarDTO car);
}
