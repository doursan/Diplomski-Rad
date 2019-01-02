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
@Mapper(uses = {CarPartMapper.class, ServiceMapper.class})
public interface ItemMapper {

    @Mapping(target = "rowNumber", source = "id")
    @Mapping(target = "repairId", source = "repair.id")
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "pricePerUnit", ignore = true)
    ItemDTO itemEntityToDto(ItemEntity item);

    @Mapping(target = "repair.id", source = "repairId")
    @Mapping(target = "id", source = "rowNumber")
    ItemEntity itemDtoToEntity(ItemDTO item);
}
