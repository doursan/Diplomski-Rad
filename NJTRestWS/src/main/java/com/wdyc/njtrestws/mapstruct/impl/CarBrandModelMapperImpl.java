package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.CarBrandEntity;
import com.wdyc.njtrestws.domen.CarBrandModelEntity;
import com.wdyc.njtrestws.domen.ModelEngineEntity;
import com.wdyc.njtrestws.dto.CarBrandDTO;
import com.wdyc.njtrestws.dto.CarBrandModelDTO;
import com.wdyc.njtrestws.dto.ModelEngineDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-16T02:12:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarBrandModelMapperImpl implements CarBrandModelMapper {

    private final ModelEngineMapper modelEngineMapper = Mappers.getMapper( ModelEngineMapper.class );

    @Override
    public CarBrandModelDTO carBrandModelEntityToDto(CarBrandModelEntity carBrandModel) {
        if ( carBrandModel == null ) {
            return null;
        }

        CarBrandModelDTO carBrandModelDTO = new CarBrandModelDTO();

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
        carBrandModelDTO.setModelEngineList( modelEngineEntityListToModelEngineDTOList( carBrandModel.getModelEngineList() ) );

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
        carBrandModelEntity.setCarBrand( carBrandDTOToCarBrandEntity( carBrandModel.getCarBrand() ) );
        carBrandModelEntity.setModelEngineList( modelEngineDTOListToModelEngineEntityList( carBrandModel.getModelEngineList() ) );

        return carBrandModelEntity;
    }

    protected List<ModelEngineDTO> modelEngineEntityListToModelEngineDTOList(List<ModelEngineEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ModelEngineDTO> list1 = new ArrayList<ModelEngineDTO>( list.size() );
        for ( ModelEngineEntity modelEngineEntity : list ) {
            list1.add( modelEngineMapper.modelEngineEntityToDto( modelEngineEntity ) );
        }

        return list1;
    }

    protected List<CarBrandModelEntity> carBrandModelDTOListToCarBrandModelEntityList(List<CarBrandModelDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandModelEntity> list1 = new ArrayList<CarBrandModelEntity>( list.size() );
        for ( CarBrandModelDTO carBrandModelDTO : list ) {
            list1.add( carBrandModelDtoToEntity( carBrandModelDTO ) );
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

    protected List<ModelEngineEntity> modelEngineDTOListToModelEngineEntityList(List<ModelEngineDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ModelEngineEntity> list1 = new ArrayList<ModelEngineEntity>( list.size() );
        for ( ModelEngineDTO modelEngineDTO : list ) {
            list1.add( modelEngineMapper.modelEngineDtoToEntity( modelEngineDTO ) );
        }

        return list1;
    }
}
