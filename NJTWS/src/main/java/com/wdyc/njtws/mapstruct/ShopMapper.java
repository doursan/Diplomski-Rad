/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.ShopEntity;
import com.wdyc.njtws.dto.ShopDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper
public interface ShopMapper {
    
    ShopDTO shopEntityToDto(ShopEntity shop);
    ShopEntity shopDtoToEntity(ShopDTO shop);
}
