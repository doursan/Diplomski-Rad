package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.CarBrandEntity;
import com.wdyc.njtws.domen.CarBrandModelEntity;
import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.domen.ClientEntity;
import com.wdyc.njtws.domen.EngineEntity;
import com.wdyc.njtws.dto.CarBrandDTO;
import com.wdyc.njtws.dto.CarBrandModelDTO;
import com.wdyc.njtws.dto.CarDTO;
import com.wdyc.njtws.dto.ClientDTO;
import com.wdyc.njtws.dto.EngineDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-10T00:02:06+0200",
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

    protected List<CarBrandModelDTO> carBrandModelEntityListToCarBrandModelDTOList(List<CarBrandModelEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandModelDTO> list1 = new ArrayList<CarBrandModelDTO>( list.size() );
        for ( CarBrandModelEntity carBrandModelEntity : list ) {
            list1.add( carBrandModelEntityToCarBrandModelDTO( carBrandModelEntity ) );
        }

        return list1;
    }

    protected CarBrandDTO carBrandEntityToCarBrandDTO(CarBrandEntity carBrandEntity) {
        if ( carBrandEntity == null ) {
            return null;
        }

        CarBrandDTO carBrandDTO = new CarBrandDTO();

        carBrandDTO.setCarBrandModelList( carBrandModelEntityListToCarBrandModelDTOList( carBrandEntity.getCarBrandModelList() ) );
        if ( carBrandEntity.getId() != null ) {
            carBrandDTO.setId( String.valueOf( carBrandEntity.getId() ) );
        }
        carBrandDTO.setName( carBrandEntity.getName() );
        carBrandDTO.setCountry( carBrandEntity.getCountry() );

        return carBrandDTO;
    }

    protected CarBrandModelDTO carBrandModelEntityToCarBrandModelDTO(CarBrandModelEntity carBrandModelEntity) {
        if ( carBrandModelEntity == null ) {
            return null;
        }

        CarBrandModelDTO carBrandModelDTO = new CarBrandModelDTO();

        carBrandModelDTO.setCarBrand( carBrandEntityToCarBrandDTO( carBrandModelEntity.getCarBrand() ) );
        if ( carBrandModelEntity.getId() != null ) {
            carBrandModelDTO.setId( String.valueOf( carBrandModelEntity.getId() ) );
        }
        carBrandModelDTO.setName( carBrandModelEntity.getName() );
        if ( carBrandModelEntity.getProductionBegan() != null ) {
            carBrandModelDTO.setProductionBegan( String.valueOf( carBrandModelEntity.getProductionBegan() ) );
        }
        if ( carBrandModelEntity.getProductionEnd() != null ) {
            carBrandModelDTO.setProductionEnd( String.valueOf( carBrandModelEntity.getProductionEnd() ) );
        }

        return carBrandModelDTO;
    }

    protected EngineDTO engineEntityToEngineDTO(EngineEntity engineEntity) {
        if ( engineEntity == null ) {
            return null;
        }

        EngineDTO engineDTO = new EngineDTO();

        if ( engineEntity.getVolume() != null ) {
            engineDTO.setVolume( String.valueOf( engineEntity.getVolume() ) );
        }
        if ( engineEntity.getId() != null ) {
            engineDTO.setId( String.valueOf( engineEntity.getId() ) );
        }
        engineDTO.setName( engineEntity.getName() );
        engineDTO.setFuel( engineEntity.getFuel() );
        if ( engineEntity.getKw() != null ) {
            engineDTO.setKw( String.valueOf( engineEntity.getKw() ) );
        }
        if ( engineEntity.getHp() != null ) {
            engineDTO.setHp( String.valueOf( engineEntity.getHp() ) );
        }

        return engineDTO;
    }

    protected CarDTO carEntityToCarDTO(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setBrandModel( carBrandModelEntityToCarBrandModelDTO( carEntity.getBrandModel() ) );
        carDTO.setVin( carEntity.getVin() );
        carDTO.setRegistration( carEntity.getRegistration() );
        if ( carEntity.getProductionYear() != null ) {
            carDTO.setProductionYear( String.valueOf( carEntity.getProductionYear() ) );
        }
        carDTO.setClient( clientEntityToDto( carEntity.getClient() ) );
        carDTO.setEngine( engineEntityToEngineDTO( carEntity.getEngine() ) );

        return carDTO;
    }

    protected List<CarDTO> carEntityListToCarDTOList(List<CarEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CarDTO> list1 = new ArrayList<CarDTO>( list.size() );
        for ( CarEntity carEntity : list ) {
            list1.add( carEntityToCarDTO( carEntity ) );
        }

        return list1;
    }

    protected EngineEntity engineDTOToEngineEntity(EngineDTO engineDTO) {
        if ( engineDTO == null ) {
            return null;
        }

        EngineEntity engineEntity = new EngineEntity();

        if ( engineDTO.getId() != null ) {
            engineEntity.setId( Integer.parseInt( engineDTO.getId() ) );
        }
        engineEntity.setName( engineDTO.getName() );
        engineEntity.setFuel( engineDTO.getFuel() );
        if ( engineDTO.getKw() != null ) {
            engineEntity.setKw( Integer.parseInt( engineDTO.getKw() ) );
        }
        if ( engineDTO.getHp() != null ) {
            engineEntity.setHp( Integer.parseInt( engineDTO.getHp() ) );
        }
        if ( engineDTO.getVolume() != null ) {
            engineEntity.setVolume( Integer.parseInt( engineDTO.getVolume() ) );
        }

        return engineEntity;
    }

    protected List<CarBrandModelEntity> carBrandModelDTOListToCarBrandModelEntityList(List<CarBrandModelDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandModelEntity> list1 = new ArrayList<CarBrandModelEntity>( list.size() );
        for ( CarBrandModelDTO carBrandModelDTO : list ) {
            list1.add( carBrandModelDTOToCarBrandModelEntity( carBrandModelDTO ) );
        }

        return list1;
    }

    protected CarBrandEntity carBrandDTOToCarBrandEntity(CarBrandDTO carBrandDTO) {
        if ( carBrandDTO == null ) {
            return null;
        }

        CarBrandEntity carBrandEntity = new CarBrandEntity();

        if ( carBrandDTO.getId() != null ) {
            carBrandEntity.setId( Integer.parseInt( carBrandDTO.getId() ) );
        }
        carBrandEntity.setName( carBrandDTO.getName() );
        carBrandEntity.setCountry( carBrandDTO.getCountry() );
        carBrandEntity.setCarBrandModelList( carBrandModelDTOListToCarBrandModelEntityList( carBrandDTO.getCarBrandModelList() ) );

        return carBrandEntity;
    }

    protected CarBrandModelEntity carBrandModelDTOToCarBrandModelEntity(CarBrandModelDTO carBrandModelDTO) {
        if ( carBrandModelDTO == null ) {
            return null;
        }

        CarBrandModelEntity carBrandModelEntity = new CarBrandModelEntity();

        if ( carBrandModelDTO.getId() != null ) {
            carBrandModelEntity.setId( Integer.parseInt( carBrandModelDTO.getId() ) );
        }
        carBrandModelEntity.setName( carBrandModelDTO.getName() );
        if ( carBrandModelDTO.getProductionBegan() != null ) {
            carBrandModelEntity.setProductionBegan( Short.parseShort( carBrandModelDTO.getProductionBegan() ) );
        }
        if ( carBrandModelDTO.getProductionEnd() != null ) {
            carBrandModelEntity.setProductionEnd( Short.parseShort( carBrandModelDTO.getProductionEnd() ) );
        }
        carBrandModelEntity.setCarBrand( carBrandDTOToCarBrandEntity( carBrandModelDTO.getCarBrand() ) );

        return carBrandModelEntity;
    }

    protected CarEntity carDTOToCarEntity(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setVin( carDTO.getVin() );
        carEntity.setRegistration( carDTO.getRegistration() );
        if ( carDTO.getProductionYear() != null ) {
            carEntity.setProductionYear( Short.parseShort( carDTO.getProductionYear() ) );
        }
        carEntity.setClient( clientDtoToEntity( carDTO.getClient() ) );
        carEntity.setEngine( engineDTOToEngineEntity( carDTO.getEngine() ) );
        carEntity.setBrandModel( carBrandModelDTOToCarBrandModelEntity( carDTO.getBrandModel() ) );

        return carEntity;
    }

    protected List<CarEntity> carDTOListToCarEntityList(List<CarDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarEntity> list1 = new ArrayList<CarEntity>( list.size() );
        for ( CarDTO carDTO : list ) {
            list1.add( carDTOToCarEntity( carDTO ) );
        }

        return list1;
    }
}
