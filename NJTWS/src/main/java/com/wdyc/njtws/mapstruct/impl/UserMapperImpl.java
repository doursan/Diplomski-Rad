package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.UserEntity;
import com.wdyc.njtws.dto.UserDTO;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-10T00:02:07+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@ApplicationScoped
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDtoToEntity(UserDTO user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        if ( user.getId() != null ) {
            userEntity.setId( Integer.parseInt( user.getId() ) );
        }
        userEntity.setUsername( user.getUsername() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setType( user.getType() );

        return userEntity;
    }

    @Override
    public UserDTO userEntityToDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setPassword( user.getPassword() );
        if ( user.getId() != null ) {
            userDTO.setId( String.valueOf( user.getId() ) );
        }
        userDTO.setUsername( user.getUsername() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setType( user.getType() );

        return userDTO;
    }
}
