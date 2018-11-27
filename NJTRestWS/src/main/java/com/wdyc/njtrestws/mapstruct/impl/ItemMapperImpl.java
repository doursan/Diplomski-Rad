package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.ItemEntityPK;
import com.wdyc.njtrestws.dto.ItemDTO;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-11-26T01:41:19+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ItemMapperImpl implements ItemMapper {

    private final CarPartMapper carPartMapper = Mappers.getMapper( CarPartMapper.class );
    private final ServiceMapper serviceMapper = Mappers.getMapper( ServiceMapper.class );

    @Override
    public ItemDTO itemEntityToDto(ItemEntity item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        int id = itemItemPKId( item );
        itemDTO.setRowNumber( id );
        int repairId = itemItemPKRepairId( item );
        itemDTO.setRepairId( repairId );
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
        itemEntity.getItemPK().setId(item.getRowNumber());

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

    private int itemItemPKId(ItemEntity itemEntity) {
        if ( itemEntity == null ) {
            return 0;
        }
        ItemEntityPK itemPK = itemEntity.getItemPK();
        if ( itemPK == null ) {
            return 0;
        }
        int id = itemPK.getId();
        return id;
    }

    private int itemItemPKRepairId(ItemEntity itemEntity) {
        if ( itemEntity == null ) {
            return 0;
        }
        ItemEntityPK itemPK = itemEntity.getItemPK();
        if ( itemPK == null ) {
            return 0;
        }
        int repairId = itemPK.getRepairId();
        return repairId;
    }
}
