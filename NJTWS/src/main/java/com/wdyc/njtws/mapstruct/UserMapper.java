/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.mapstruct;

import com.wdyc.njtws.domen.UserEntity;
import com.wdyc.njtws.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper(componentModel = "cdi")
public interface UserMapper {
    
    UserEntity userDtoToEntity(UserDTO user);
    
    UserDTO userEntityToDto(UserEntity user);
}
