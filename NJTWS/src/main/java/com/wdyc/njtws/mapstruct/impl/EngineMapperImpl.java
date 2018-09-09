package com.wdyc.njtws.mapstruct.impl;

import com.wdyc.njtws.mapstruct.*;
import com.wdyc.njtws.domen.EngineEntity;
import com.wdyc.njtws.dto.EngineDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-10T00:02:07+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class EngineMapperImpl implements EngineMapper {

    @Override
    public EngineDTO engineEntityToDto(EngineEntity engine) {
        if ( engine == null ) {
            return null;
        }

        EngineDTO engineDTO = new EngineDTO();

        if ( engine.getVolume() != null ) {
            engineDTO.setVolume( String.valueOf( engine.getVolume() ) );
        }
        if ( engine.getId() != null ) {
            engineDTO.setId( String.valueOf( engine.getId() ) );
        }
        engineDTO.setName( engine.getName() );
        engineDTO.setFuel( engine.getFuel() );
        if ( engine.getKw() != null ) {
            engineDTO.setKw( String.valueOf( engine.getKw() ) );
        }
        if ( engine.getHp() != null ) {
            engineDTO.setHp( String.valueOf( engine.getHp() ) );
        }

        return engineDTO;
    }

    @Override
    public EngineEntity engineDtoToEntity(EngineDTO engine) {
        if ( engine == null ) {
            return null;
        }

        EngineEntity engineEntity = new EngineEntity();

        if ( engine.getId() != null ) {
            engineEntity.setId( Integer.parseInt( engine.getId() ) );
        }
        engineEntity.setName( engine.getName() );
        engineEntity.setFuel( engine.getFuel() );
        if ( engine.getKw() != null ) {
            engineEntity.setKw( Integer.parseInt( engine.getKw() ) );
        }
        if ( engine.getHp() != null ) {
            engineEntity.setHp( Integer.parseInt( engine.getHp() ) );
        }
        if ( engine.getVolume() != null ) {
            engineEntity.setVolume( Integer.parseInt( engine.getVolume() ) );
        }

        return engineEntity;
    }
}
