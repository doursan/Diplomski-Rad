package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.dto.CarDTO;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-08T01:00:48+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarMapperImpl implements CarMapper {

    private final CarBrandModelMapper carBrandModelMapper = Mappers.getMapper( CarBrandModelMapper.class );
    private final EngineMapper engineMapper = Mappers.getMapper( EngineMapper.class );
    private final ClientMapper clientMapper = Mappers.getMapper( ClientMapper.class );

    @Override
    public CarDTO carEntityToDto(CarEntity car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setBrandModel( carBrandModelMapper.carBrandModelEntityToDto( car.getBrandModel() ) );
        carDTO.setVin( car.getVin() );
        carDTO.setRegistration( car.getRegistration() );
        if ( car.getProductionYear() != null ) {
            carDTO.setProductionYear( String.valueOf( car.getProductionYear() ) );
        }
        carDTO.setClient( clientMapper.clientEntityToDto( car.getClient() ) );
        carDTO.setEngine( engineMapper.engineEntityToDto( car.getEngine() ) );

        return carDTO;
    }

    @Override
    public CarEntity carDtoToEntity(CarDTO car) {
        if ( car == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setVin( car.getVin() );
        carEntity.setRegistration( car.getRegistration() );
        if ( car.getProductionYear() != null ) {
            carEntity.setProductionYear( Short.parseShort( car.getProductionYear() ) );
        }
        carEntity.setClient( clientMapper.clientDtoToEntity( car.getClient() ) );
        carEntity.setEngine( engineMapper.engineDtoToEntity( car.getEngine() ) );
        carEntity.setBrandModel( carBrandModelMapper.carBrandModelDtoToEntity( car.getBrandModel() ) );

        return carEntity;
    }
}
