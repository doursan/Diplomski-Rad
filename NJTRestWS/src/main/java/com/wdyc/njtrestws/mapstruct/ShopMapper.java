/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.ShopEntity;
import com.wdyc.njtrestws.dto.ShopDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper
public interface ShopMapper {
    
    @Mapping(target = "repairList", ignore = true)
    ShopDTO shopEntityToDto(ShopEntity shop);
    
    @Mapping(target = "repairList", ignore = true)
    ShopEntity shopDtoToEntity(ShopDTO shop);
}
