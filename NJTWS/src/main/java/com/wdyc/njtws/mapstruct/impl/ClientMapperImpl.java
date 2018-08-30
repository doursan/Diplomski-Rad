package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.ClientEntity;
import com.wdyc.njtws.dto.ClientDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-08-30T23:35:44+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO clientEntityToDto(ClientEntity client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setPassword( client.getPassword() );
        if ( client.getId() != null ) {
            clientDTO.setId( String.valueOf( client.getId() ) );
        }
        clientDTO.setUsername( client.getUsername() );
        clientDTO.setEmail( client.getEmail() );
        clientDTO.setType( client.getType() );
        clientDTO.setJmbg( client.getJmbg() );
        clientDTO.setIme( client.getIme() );
        clientDTO.setPrezime( client.getPrezime() );

        return clientDTO;
    }

    @Override
    public ClientEntity clientDtoToEntity(ClientDTO client) {
        if ( client == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        if ( client.getId() != null ) {
            clientEntity.setId( Integer.parseInt( client.getId() ) );
        }
        clientEntity.setUsername( client.getUsername() );
        clientEntity.setPassword( client.getPassword() );
        clientEntity.setEmail( client.getEmail() );
        clientEntity.setType( client.getType() );
        clientEntity.setIme( client.getIme() );
        clientEntity.setPrezime( client.getPrezime() );
        clientEntity.setJmbg( client.getJmbg() );

        return clientEntity;
    }
}
