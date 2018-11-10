/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.mapstruct;

import com.wdyc.njtrestws.domen.ItemEntityPK;
import com.wdyc.njtrestws.dto.ItemDTOPK;
import org.mapstruct.Mapper;

/**
 *
 * @author Dusan
 */
@Mapper
public interface ItemPKMapper {
    
    ItemDTOPK itemEntityPKToDto(ItemEntityPK itemPk);
    
    ItemEntityPK itemDtoPKToEntity(ItemDTOPK itemPk);
}
