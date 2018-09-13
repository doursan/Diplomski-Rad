package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.CarBrandEntity;
import com.wdyc.njtrestws.domen.CarBrandsEngines;
import com.wdyc.njtrestws.domen.EngineEntity;
import com.wdyc.njtrestws.dto.CarBrandDTO;
import com.wdyc.njtrestws.dto.CarBrandsEnginesDTO;
import com.wdyc.njtrestws.dto.EngineDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-12T18:38:26+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarBrandsEnginesMapperImpl implements CarBrandsEnginesMapper {

    private final CarBrandMapper carBrandMapper = Mappers.getMapper( CarBrandMapper.class );
    private final EngineMapper engineMapper = Mappers.getMapper( EngineMapper.class );

    @Override
    public CarBrandsEnginesDTO carBrandsEnginesToDto(CarBrandsEngines cbe) {
        if ( cbe == null ) {
            return null;
        }

        CarBrandsEnginesDTO carBrandsEnginesDTO = new CarBrandsEnginesDTO();

        carBrandsEnginesDTO.setEngines( engineEntityListToEngineDTOList( cbe.getEngines() ) );
        carBrandsEnginesDTO.setCarBrands( carBrandEntityListToCarBrandDTOList( cbe.getCarBrands() ) );

        return carBrandsEnginesDTO;
    }

    @Override
    public CarBrandsEngines carBrandsEnginesDtoToCBE(CarBrandsEnginesDTO cbeDto) {
        if ( cbeDto == null ) {
            return null;
        }

        CarBrandsEngines carBrandsEngines = new CarBrandsEngines();

        carBrandsEngines.setCarBrands( carBrandDTOListToCarBrandEntityList( cbeDto.getCarBrands() ) );
        carBrandsEngines.setEngines( engineDTOListToEngineEntityList( cbeDto.getEngines() ) );

        return carBrandsEngines;
    }

    protected List<EngineDTO> engineEntityListToEngineDTOList(List<EngineEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<EngineDTO> list1 = new ArrayList<EngineDTO>( list.size() );
        for ( EngineEntity engineEntity : list ) {
            list1.add( engineMapper.engineEntityToDto( engineEntity ) );
        }

        return list1;
    }

    protected List<CarBrandDTO> carBrandEntityListToCarBrandDTOList(List<CarBrandEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandDTO> list1 = new ArrayList<CarBrandDTO>( list.size() );
        for ( CarBrandEntity carBrandEntity : list ) {
            list1.add( carBrandMapper.carBrandEntityToDto( carBrandEntity ) );
        }

        return list1;
    }

    protected List<CarBrandEntity> carBrandDTOListToCarBrandEntityList(List<CarBrandDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandEntity> list1 = new ArrayList<CarBrandEntity>( list.size() );
        for ( CarBrandDTO carBrandDTO : list ) {
            list1.add( carBrandMapper.carBrandDtoToEntity( carBrandDTO ) );
        }

        return list1;
    }

    protected List<EngineEntity> engineDTOListToEngineEntityList(List<EngineDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<EngineEntity> list1 = new ArrayList<EngineEntity>( list.size() );
        for ( EngineDTO engineDTO : list ) {
            list1.add( engineMapper.engineDtoToEntity( engineDTO ) );
        }

        return list1;
    }
}
