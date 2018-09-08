/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.EngineEntity;
import com.wdyc.njtws.dto.EngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper
public interface EngineMapper {
    
    EngineDTO engineEntityToDto(EngineEntity engine);
    @Mapping(target = "carEntityList", ignore = true)
    EngineEntity engineDtoToEntity(EngineDTO engine);
}
