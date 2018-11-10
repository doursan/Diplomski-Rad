/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.RepairEntity;
import com.wdyc.njtrestws.dto.RepairDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper(uses = {CarMapper.class, ShopMapper.class, ItemMapper.class})
public interface RepairMapper {
    
    @Mapping(target = "car", ignore = true)
    RepairDTO repairEntityToDto(RepairEntity repair);
    
    RepairEntity repairDtoToEntity(RepairDTO repair);
}
