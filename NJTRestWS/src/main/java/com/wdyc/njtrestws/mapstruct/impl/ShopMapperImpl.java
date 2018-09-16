package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ShopEntity;
import com.wdyc.njtrestws.dto.ShopDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-16T02:12:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ShopMapperImpl implements ShopMapper {

    @Override
    public ShopDTO shopEntityToDto(ShopEntity shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDTO shopDTO = new ShopDTO();

        shopDTO.setPassword( shop.getPassword() );
        if ( shop.getId() != null ) {
            shopDTO.setId( String.valueOf( shop.getId() ) );
        }
        shopDTO.setUsername( shop.getUsername() );
        shopDTO.setEmail( shop.getEmail() );
        shopDTO.setTip( shop.getTip() );
        shopDTO.setMaticni( shop.getMaticni() );
        shopDTO.setNaziv( shop.getNaziv() );
        shopDTO.setPib( shop.getPib() );

        return shopDTO;
    }

    @Override
    public ShopEntity shopDtoToEntity(ShopDTO shop) {
        if ( shop == null ) {
            return null;
        }

        ShopEntity shopEntity = new ShopEntity();

        if ( shop.getId() != null ) {
            shopEntity.setId( Integer.parseInt( shop.getId() ) );
        }
        shopEntity.setUsername( shop.getUsername() );
        shopEntity.setPassword( shop.getPassword() );
        shopEntity.setEmail( shop.getEmail() );
        shopEntity.setTip( shop.getTip() );
        shopEntity.setNaziv( shop.getNaziv() );
        shopEntity.setPib( shop.getPib() );
        shopEntity.setMaticni( shop.getMaticni() );

        return shopEntity;
    }
}
