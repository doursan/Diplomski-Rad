package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ServiceEntity;
import com.wdyc.njtrestws.dto.ServiceDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-26T01:41:18+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public ServiceDTO serviceEntityToDto(ServiceEntity service) {
        if ( service == null ) {
            return null;
        }

        ServiceDTO serviceDTO = new ServiceDTO();

        if ( service.getId() != null ) {
            serviceDTO.setId( String.valueOf( service.getId() ) );
        }
        serviceDTO.setHours( String.valueOf( service.getHours() ) );
        if ( service.getPrice() != null ) {
            serviceDTO.setPrice( String.valueOf( service.getPrice() ) );
        }
        serviceDTO.setName( service.getName() );

        return serviceDTO;
    }

    @Override
    public ServiceEntity serviceDtoToEntity(ServiceDTO service) {
        if ( service == null ) {
            return null;
        }

        ServiceEntity serviceEntity = new ServiceEntity();

        if ( service.getId() != null ) {
            serviceEntity.setId( Integer.parseInt( service.getId() ) );
        }
        if ( service.getHours() != null ) {
            serviceEntity.setHours( Double.parseDouble( service.getHours() ) );
        }
        if ( service.getPrice() != null ) {
            serviceEntity.setPrice( Double.parseDouble( service.getPrice() ) );
        }
        serviceEntity.setName( service.getName() );

        return serviceEntity;
    }
}
