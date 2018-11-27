package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.CarPartEntity;
import com.wdyc.njtrestws.dto.CarPartDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-26T01:41:19+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarPartMapperImpl implements CarPartMapper {

    @Override
    public CarPartDTO carPartEntityToDto(CarPartEntity carPart) {
        if ( carPart == null ) {
            return null;
        }

        CarPartDTO carPartDTO = new CarPartDTO();

        if ( carPart.getId() != null ) {
            carPartDTO.setId( String.valueOf( carPart.getId() ) );
        }
        carPartDTO.setName( carPart.getName() );
        if ( carPart.getPrice() != null ) {
            carPartDTO.setPrice( String.valueOf( carPart.getPrice() ) );
        }

        return carPartDTO;
    }

    @Override
    public CarPartEntity carPartDtoToEntity(CarPartDTO carPart) {
        if ( carPart == null ) {
            return null;
        }

        CarPartEntity carPartEntity = new CarPartEntity();

        if ( carPart.getId() != null ) {
            carPartEntity.setId( Integer.parseInt( carPart.getId() ) );
        }
        carPartEntity.setName( carPart.getName() );
        if ( carPart.getPrice() != null ) {
            carPartEntity.setPrice( Double.parseDouble( carPart.getPrice() ) );
        }

        return carPartEntity;
    }
}
