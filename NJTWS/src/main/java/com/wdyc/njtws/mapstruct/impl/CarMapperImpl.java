package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.dto.CarDTO;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-13T17:25:15+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarMapperImpl implements CarMapper {

    private final ModelEngineMapper modelEngineMapper = Mappers.getMapper( ModelEngineMapper.class );
    private final ClientMapper clientMapper = Mappers.getMapper( ClientMapper.class );

    @Override
    public CarDTO carEntityToDto(CarEntity car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        if ( car.getId() != null ) {
            carDTO.setId( String.valueOf( car.getId() ) );
        }
        carDTO.setVin( car.getVin() );
        carDTO.setRegistration( car.getRegistration() );
        if ( car.getProductionYear() != null ) {
            carDTO.setProductionYear( String.valueOf( car.getProductionYear() ) );
        }
        carDTO.setOwner( clientMapper.clientEntityToDto( car.getOwner() ) );
        carDTO.setModelEngine( modelEngineMapper.modelEngineEntityToDto( car.getModelEngine() ) );

        return carDTO;
    }

    @Override
    public CarEntity carDtoToEntity(CarDTO car) {
        if ( car == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        if ( car.getId() != null ) {
            carEntity.setId( Integer.parseInt( car.getId() ) );
        }
        carEntity.setVin( car.getVin() );
        carEntity.setRegistration( car.getRegistration() );
        if ( car.getProductionYear() != null ) {
            carEntity.setProductionYear( Short.parseShort( car.getProductionYear() ) );
        }
        carEntity.setOwner( clientMapper.clientDtoToEntity( car.getOwner() ) );
        carEntity.setModelEngine( modelEngineMapper.modelEngineDtoToEntity( car.getModelEngine() ) );

        return carEntity;
    }
}
