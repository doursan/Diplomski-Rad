package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.domen.ClientEntity;
import com.wdyc.njtws.dto.CarDTO;
import com.wdyc.njtws.dto.ClientDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-08T01:00:49+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    private final CarMapper carMapper = Mappers.getMapper( CarMapper.class );

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
        clientDTO.setCarList( carEntityListToCarDTOList( client.getCarList() ) );

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
        clientEntity.setCarList( carDTOListToCarEntityList( client.getCarList() ) );

        return clientEntity;
    }

    protected List<CarDTO> carEntityListToCarDTOList(List<CarEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CarDTO> list1 = new ArrayList<CarDTO>( list.size() );
        for ( CarEntity carEntity : list ) {
            list1.add( carMapper.carEntityToDto( carEntity ) );
        }

        return list1;
    }

    protected List<CarEntity> carDTOListToCarEntityList(List<CarDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarEntity> list1 = new ArrayList<CarEntity>( list.size() );
        for ( CarDTO carDTO : list ) {
            list1.add( carMapper.carDtoToEntity( carDTO ) );
        }

        return list1;
    }
}
