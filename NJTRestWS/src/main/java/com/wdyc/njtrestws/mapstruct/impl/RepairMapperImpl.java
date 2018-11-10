package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.RepairEntity;
import com.wdyc.njtrestws.dto.ItemDTO;
import com.wdyc.njtrestws.dto.RepairDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-10-08T16:24:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class RepairMapperImpl implements RepairMapper {

    private final CarMapper carMapper = Mappers.getMapper( CarMapper.class );
    private final ShopMapper shopMapper = Mappers.getMapper( ShopMapper.class );
    private final ItemMapper itemMapper = Mappers.getMapper( ItemMapper.class );

    @Override
    public RepairDTO repairEntityToDto(RepairEntity repair) {
        if ( repair == null ) {
            return null;
        }

        RepairDTO repairDTO = new RepairDTO();

        if ( repair.getId() != null ) {
            repairDTO.setId( String.valueOf( repair.getId() ) );
        }
        repairDTO.setDatum( repair.getDatum() );
        repairDTO.setKilometers( String.valueOf( repair.getKilometers() ) );
        repairDTO.setIsActive( repair.getIsActive() );
        if ( repair.getPrice() != null ) {
            repairDTO.setPrice( String.valueOf( repair.getPrice() ) );
        }
        repairDTO.setShop( shopMapper.shopEntityToDto( repair.getShop() ) );
        repairDTO.setItemList( itemEntityListToItemDTOList( repair.getItemList() ) );

        return repairDTO;
    }

    @Override
    public RepairEntity repairDtoToEntity(RepairDTO repair) {
        if ( repair == null ) {
            return null;
        }

        RepairEntity repairEntity = new RepairEntity();

        if ( repair.getId() != null ) {
            repairEntity.setId( Integer.parseInt( repair.getId() ) );
        }
        repairEntity.setDatum( repair.getDatum() );
        if ( repair.getKilometers() != null ) {
            repairEntity.setKilometers( Integer.parseInt( repair.getKilometers() ) );
        }
        repairEntity.setIsActive( repair.isIsActive() );
        if ( repair.getPrice() != null ) {
            repairEntity.setPrice( Double.parseDouble( repair.getPrice() ) );
        }
        repairEntity.setCar( carMapper.carDtoToEntity( repair.getCar() ) );
        repairEntity.setShop( shopMapper.shopDtoToEntity( repair.getShop() ) );
        repairEntity.setItemList( itemDTOListToItemEntityList( repair.getItemList() ) );

        return repairEntity;
    }

    protected List<ItemDTO> itemEntityListToItemDTOList(List<ItemEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemDTO> list1 = new ArrayList<ItemDTO>( list.size() );
        for ( ItemEntity itemEntity : list ) {
            list1.add( itemMapper.itemEntityToDto( itemEntity ) );
        }

        return list1;
    }

    protected List<ItemEntity> itemDTOListToItemEntityList(List<ItemDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemEntity> list1 = new ArrayList<ItemEntity>( list.size() );
        for ( ItemDTO itemDTO : list ) {
            list1.add( itemMapper.itemDtoToEntity( itemDTO ) );
        }

        return list1;
    }
}
