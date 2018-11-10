package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.dto.ItemDTO;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-10-08T16:24:09+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ItemMapperImpl implements ItemMapper {

    private final ItemPKMapper itemPKMapper = Mappers.getMapper( ItemPKMapper.class );
    private final CarPartMapper carPartMapper = Mappers.getMapper( CarPartMapper.class );
    private final ServiceMapper serviceMapper = Mappers.getMapper( ServiceMapper.class );

    @Override
    public ItemDTO itemEntityToDto(ItemEntity item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemPK( itemPKMapper.itemEntityPKToDto( item.getItemPK() ) );
        if ( item.getAmount() != null ) {
            itemDTO.setAmount( String.valueOf( item.getAmount() ) );
        }
        if ( item.getPrice() != null ) {
            itemDTO.setPrice( String.valueOf( item.getPrice() ) );
        }
        itemDTO.setCarPart( carPartMapper.carPartEntityToDto( item.getCarPart() ) );
        itemDTO.setService( serviceMapper.serviceEntityToDto( item.getService() ) );

        return itemDTO;
    }

    @Override
    public ItemEntity itemDtoToEntity(ItemDTO item) {
        if ( item == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setItemPK( itemPKMapper.itemDtoPKToEntity( item.getItemPK() ) );
        if ( item.getAmount() != null ) {
            itemEntity.setAmount( Double.parseDouble( item.getAmount() ) );
        }
        if ( item.getPrice() != null ) {
            itemEntity.setPrice( Double.parseDouble( item.getPrice() ) );
        }
        itemEntity.setCarPart( carPartMapper.carPartDtoToEntity( item.getCarPart() ) );
        itemEntity.setService( serviceMapper.serviceDtoToEntity( item.getService() ) );

        return itemEntity;
    }
}
