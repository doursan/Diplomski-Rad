package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.CarBrandEntity;
import com.wdyc.njtws.domen.CarBrandModelEntity;
import com.wdyc.njtws.domen.CarEntity;
import com.wdyc.njtws.domen.ClientEntity;
import com.wdyc.njtws.domen.ModelEngineEntity;
import com.wdyc.njtws.dto.CarBrandDTO;
import com.wdyc.njtws.dto.CarBrandModelDTO;
import com.wdyc.njtws.dto.CarDTO;
import com.wdyc.njtws.dto.ClientDTO;
import com.wdyc.njtws.dto.ModelEngineDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-13T17:25:15+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ModelEngineMapperImpl implements ModelEngineMapper {

    private final EngineMapper engineMapper = Mappers.getMapper( EngineMapper.class );

    @Override
    public ModelEngineDTO modelEngineEntityToDto(ModelEngineEntity modelEngine) {
        if ( modelEngine == null ) {
            return null;
        }

        ModelEngineDTO modelEngineDTO = new ModelEngineDTO();

        modelEngineDTO.setModel( carBrandModelEntityToCarBrandModelDTO( modelEngine.getModel() ) );
        if ( modelEngine.getId() != null ) {
            modelEngineDTO.setId( String.valueOf( modelEngine.getId() ) );
        }
        modelEngineDTO.setEngine( engineMapper.engineEntityToDto( modelEngine.getEngine() ) );

        return modelEngineDTO;
    }

    @Override
    public ModelEngineEntity modelEngineDtoToEntity(ModelEngineDTO modelEngine) {
        if ( modelEngine == null ) {
            return null;
        }

        ModelEngineEntity modelEngineEntity = new ModelEngineEntity();

        if ( modelEngine.getId() != null ) {
            modelEngineEntity.setId( Integer.parseInt( modelEngine.getId() ) );
        }
        modelEngineEntity.setCarEntityList( carDTOListToCarEntityList( modelEngine.getCarEntityList() ) );
        modelEngineEntity.setEngine( engineMapper.engineDtoToEntity( modelEngine.getEngine() ) );
        modelEngineEntity.setModel( carBrandModelDTOToCarBrandModelEntity( modelEngine.getModel() ) );

        return modelEngineEntity;
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

    protected List<ModelEngineDTO> modelEngineEntityListToModelEngineDTOList(List<ModelEngineEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ModelEngineDTO> list1 = new ArrayList<ModelEngineDTO>( list.size() );
        for ( ModelEngineEntity modelEngineEntity : list ) {
            list1.add( modelEngineEntityToDto( modelEngineEntity ) );
        }

        return list1;
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
        carBrandModelDTO.setModelEngineList( modelEngineEntityListToModelEngineDTOList( carBrandModelEntity.getModelEngineList() ) );

        return carBrandModelDTO;
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

    protected ClientEntity clientDTOToClientEntity(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        if ( clientDTO.getId() != null ) {
            clientEntity.setId( Integer.parseInt( clientDTO.getId() ) );
        }
        clientEntity.setUsername( clientDTO.getUsername() );
        clientEntity.setPassword( clientDTO.getPassword() );
        clientEntity.setEmail( clientDTO.getEmail() );
        clientEntity.setType( clientDTO.getType() );
        clientEntity.setIme( clientDTO.getIme() );
        clientEntity.setPrezime( clientDTO.getPrezime() );
        clientEntity.setJmbg( clientDTO.getJmbg() );
        clientEntity.setCarList( carDTOListToCarEntityList( clientDTO.getCarList() ) );

        return clientEntity;
    }

    protected CarEntity carDTOToCarEntity(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        if ( carDTO.getId() != null ) {
            carEntity.setId( Integer.parseInt( carDTO.getId() ) );
        }
        carEntity.setVin( carDTO.getVin() );
        carEntity.setRegistration( carDTO.getRegistration() );
        if ( carDTO.getProductionYear() != null ) {
            carEntity.setProductionYear( Short.parseShort( carDTO.getProductionYear() ) );
        }
        carEntity.setOwner( clientDTOToClientEntity( carDTO.getOwner() ) );
        carEntity.setModelEngine( modelEngineDtoToEntity( carDTO.getModelEngine() ) );

        return carEntity;
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

    protected List<ModelEngineEntity> modelEngineDTOListToModelEngineEntityList(List<ModelEngineDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ModelEngineEntity> list1 = new ArrayList<ModelEngineEntity>( list.size() );
        for ( ModelEngineDTO modelEngineDTO : list ) {
            list1.add( modelEngineDtoToEntity( modelEngineDTO ) );
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
        carBrandModelEntity.setCarBrand( carBrandDTOToCarBrandEntity( carBrandModelDTO.getCarBrand() ) );
        carBrandModelEntity.setModelEngineList( modelEngineDTOListToModelEngineEntityList( carBrandModelDTO.getModelEngineList() ) );

        return carBrandModelEntity;
    }
}
