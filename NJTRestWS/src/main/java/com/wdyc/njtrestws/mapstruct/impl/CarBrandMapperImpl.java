package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.CarBrandEntity;
import com.wdyc.njtrestws.domen.CarBrandModelEntity;
import com.wdyc.njtrestws.dto.CarBrandDTO;
import com.wdyc.njtrestws.dto.CarBrandModelDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-16T02:12:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarBrandMapperImpl implements CarBrandMapper {

    private final CarBrandModelMapper carBrandModelMapper = Mappers.getMapper( CarBrandModelMapper.class );

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

    protected List<CarBrandModelDTO> carBrandModelEntityListToCarBrandModelDTOList(List<CarBrandModelEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandModelDTO> list1 = new ArrayList<CarBrandModelDTO>( list.size() );
        for ( CarBrandModelEntity carBrandModelEntity : list ) {
            list1.add( carBrandModelMapper.carBrandModelEntityToDto( carBrandModelEntity ) );
        }

        return list1;
    }

    protected List<CarBrandModelEntity> carBrandModelDTOListToCarBrandModelEntityList(List<CarBrandModelDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandModelEntity> list1 = new ArrayList<CarBrandModelEntity>( list.size() );
        for ( CarBrandModelDTO carBrandModelDTO : list ) {
            list1.add( carBrandModelMapper.carBrandModelDtoToEntity( carBrandModelDTO ) );
        }

        return list1;
    }
}
