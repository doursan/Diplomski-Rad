package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.CarBrandEntity;
import com.wdyc.njtws.domen.CarBrandModelEntity;
import com.wdyc.njtws.dto.CarBrandDTO;
import com.wdyc.njtws.dto.CarBrandModelDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-10T00:02:07+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarBrandMapperImpl implements CarBrandMapper {

    @Override
    public CarBrandDTO carBrandEntityToDto(CarBrandEntity carBrand) {
        if ( carBrand == null ) {
            return null;
        }

        CarBrandDTO carBrandDTO = new CarBrandDTO();

        carBrandDTO.setCarBrandModelList( carBrandModelEntityListToCarBrandModelDTOList( carBrand.getCarBrandModelList() ) );
        if ( carBrand.getId() != null ) {
            carBrandDTO.setId( String.valueOf( carBrand.getId() ) );
        }
        carBrandDTO.setName( carBrand.getName() );
        carBrandDTO.setCountry( carBrand.getCountry() );

        return carBrandDTO;
    }

    @Override
    public CarBrandEntity carBrandDtoToEntity(CarBrandDTO carBrand) {
        if ( carBrand == null ) {
            return null;
        }

        CarBrandEntity carBrandEntity = new CarBrandEntity();

        if ( carBrand.getId() != null ) {
            carBrandEntity.setId( Integer.parseInt( carBrand.getId() ) );
        }
        carBrandEntity.setName( carBrand.getName() );
        carBrandEntity.setCountry( carBrand.getCountry() );
        carBrandEntity.setCarBrandModelList( carBrandModelDTOListToCarBrandModelEntityList( carBrand.getCarBrandModelList() ) );

        return carBrandEntity;
    }

    protected CarBrandModelDTO carBrandModelEntityToCarBrandModelDTO(CarBrandModelEntity carBrandModelEntity) {
        if ( carBrandModelEntity == null ) {
            return null;
        }

        CarBrandModelDTO carBrandModelDTO = new CarBrandModelDTO();

        carBrandModelDTO.setCarBrand( carBrandEntityToDto( carBrandModelEntity.getCarBrand() ) );
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
        carBrandModelEntity.setCarBrand( carBrandDtoToEntity( carBrandModelDTO.getCarBrand() ) );

        return carBrandModelEntity;
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
}
