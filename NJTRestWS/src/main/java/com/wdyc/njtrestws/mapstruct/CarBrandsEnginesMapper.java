/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.CarBrandsEngines;
import com.wdyc.njtrestws.dto.CarBrandsEnginesDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper(uses = {CarBrandMapper.class, EngineMapper.class})
public interface CarBrandsEnginesMapper {
    
    CarBrandsEnginesDTO carBrandsEnginesToDto(CarBrandsEngines cbe);
    CarBrandsEngines carBrandsEnginesDtoToCBE(CarBrandsEnginesDTO cbeDto);
}
