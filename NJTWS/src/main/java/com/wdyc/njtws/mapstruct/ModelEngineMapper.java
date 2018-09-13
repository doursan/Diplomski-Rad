/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.ModelEngineEntity;
import com.wdyc.njtws.dto.ModelEngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper(uses = EngineMapper.class)
public interface ModelEngineMapper {

    @Mapping(target = "carEntityList", ignore = true)
    @Mapping(target = "model", ignore = true)
    ModelEngineDTO modelEngineEntityToDto(ModelEngineEntity modelEngine);

    ModelEngineEntity modelEngineDtoToEntity(ModelEngineDTO modelEngine);
}
