/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.ClientEntity;
import com.wdyc.njtws.dto.ClientDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper(uses = CarMapper.class)
public interface ClientMapper {

    ClientDTO clientEntityToDto(ClientEntity client);
    
    ClientEntity clientDtoToEntity(ClientDTO client);
}
