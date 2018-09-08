package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.CarBrandModelEntity;
import com.wdyc.njtws.dto.CarBrandModelDTO;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-08T01:00:49+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarBrandModelMapperImpl implements CarBrandModelMapper {

    private final CarBrandMapper carBrandMapper = Mappers.getMapper( CarBrandMapper.class );

    @Override
    public CarBrandModelDTO carBrandModelEntityToDto(CarBrandModelEntity carBrandModel) {
        if ( carBrandModel == null ) {
            return null;
        }

        CarBrandModelDTO carBrandModelDTO = new CarBrandModelDTO();

        carBrandModelDTO.setCarBrand( carBrandMapper.carBrandEntityToDto( carBrandModel.getCarBrand() ) );
        if ( carBrandModel.getId() != null ) {
            carBrandModelDTO.setId( String.valueOf( carBrandModel.getId() ) );
        }
        carBrandModelDTO.setName( carBrandModel.getName() );
        if ( carBrandModel.getProductionBegan() != null ) {
            carBrandModelDTO.setProductionBegan( String.valueOf( carBrandModel.getProductionBegan() ) );
        }
        if ( carBrandModel.getProductionEnd() != null ) {
            carBrandModelDTO.setProductionEnd( String.valueOf( carBrandModel.getProductionEnd() ) );
        }

        return carBrandModelDTO;
    }

    @Override
    public CarBrandModelEntity carBrandModelDtoToEntity(CarBrandModelDTO carBrandModel) {
        if ( carBrandModel == null ) {
            return null;
        }

        CarBrandModelEntity carBrandModelEntity = new CarBrandModelEntity();

        if ( carBrandModel.getId() != null ) {
            carBrandModelEntity.setId( Integer.parseInt( carBrandModel.getId() ) );
        }
        carBrandModelEntity.setName( carBrandModel.getName() );
        if ( carBrandModel.getProductionBegan() != null ) {
            carBrandModelEntity.setProductionBegan( Short.parseShort( carBrandModel.getProductionBegan() ) );
        }
        if ( carBrandModel.getProductionEnd() != null ) {
            carBrandModelEntity.setProductionEnd( Short.parseShort( carBrandModel.getProductionEnd() ) );
        }
        carBrandModelEntity.setCarBrand( carBrandMapper.carBrandDtoToEntity( carBrandModel.getCarBrand() ) );

        return carBrandModelEntity;
    }
}
