/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.ServiceEntity;
import com.wdyc.njtrestws.dto.ServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author Dusan
 */
@Mapper
public interface ServiceMapper {
    
    @Mapping(target = "itemList", ignore = true)
    ServiceDTO serviceEntityToDto(ServiceEntity service);
    
    @Mapping(target = "itemList", ignore = true)
    ServiceEntity serviceDtoToEntity(ServiceDTO service);
}
