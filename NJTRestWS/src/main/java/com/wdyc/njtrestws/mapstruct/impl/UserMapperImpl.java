package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.UserEntity;
import com.wdyc.njtrestws.dto.UserDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-10-08T16:24:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
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
        userEntity.setTip( user.getTip() );

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
        userDTO.setTip( user.getTip() );

        return userDTO;
    }
}
