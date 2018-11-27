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

    @Mapping(target = "rowNumber", source = "itemPK.id")
    @Mapping(target = "repairId", source = "itemPK.repairId")
    ItemDTO itemEntityToDto(ItemEntity item);

    @Mapping(target = "itemPK", ignore = true)
    ItemEntity itemDtoToEntity(ItemDTO item);
}
