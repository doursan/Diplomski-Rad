/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.UserEntity;
import com.wdyc.njtrestws.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper
public interface UserMapper {
    
    UserEntity userDtoToEntity(UserDTO user);
    
    UserDTO userEntityToDto(UserEntity user);
}
