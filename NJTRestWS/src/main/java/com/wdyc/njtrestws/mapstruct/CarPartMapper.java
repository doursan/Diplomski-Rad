/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.CarPartEntity;
import com.wdyc.njtrestws.dto.CarPartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper
public interface CarPartMapper {
    
    @Mapping(target = "itemList", ignore = true)
    CarPartDTO carPartEntityToDto(CarPartEntity carPart);
    
    @Mapping(target = "itemList", ignore = true)
    CarPartEntity carPartDtoToEntity(CarPartDTO carPart);
}
