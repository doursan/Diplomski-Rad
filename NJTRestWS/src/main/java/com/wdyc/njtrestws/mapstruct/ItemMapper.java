/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.dto.ItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper(uses = {ItemPKMapper.class, CarPartMapper.class, ServiceMapper.class})
public interface ItemMapper {
    
    ItemDTO itemEntityToDto(ItemEntity item);
    
    @Mapping(target = "repair", ignore = true)
    ItemEntity itemDtoToEntity(ItemDTO item);
}
