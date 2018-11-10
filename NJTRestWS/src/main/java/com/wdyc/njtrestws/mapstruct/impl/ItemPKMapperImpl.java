package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ItemEntityPK;
import com.wdyc.njtrestws.dto.ItemDTOPK;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-10-08T16:24:09+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ItemPKMapperImpl implements ItemPKMapper {

    @Override
    public ItemDTOPK itemEntityPKToDto(ItemEntityPK itemPk) {
        if ( itemPk == null ) {
            return null;
        }

        ItemDTOPK itemDTOPK = new ItemDTOPK();

        itemDTOPK.setRepairId( String.valueOf( itemPk.getRepairId() ) );
        itemDTOPK.setId( String.valueOf( itemPk.getId() ) );

        return itemDTOPK;
    }

    @Override
    public ItemEntityPK itemDtoPKToEntity(ItemDTOPK itemPk) {
        if ( itemPk == null ) {
            return null;
        }

        ItemEntityPK itemEntityPK = new ItemEntityPK();

        if ( itemPk.getId() != null ) {
            itemEntityPK.setId( Integer.parseInt( itemPk.getId() ) );
        }
        if ( itemPk.getRepairId() != null ) {
            itemEntityPK.setRepairId( Integer.parseInt( itemPk.getRepairId() ) );
        }

        return itemEntityPK;
    }
}
