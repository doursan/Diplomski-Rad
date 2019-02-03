package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.RepairEntity;
import com.wdyc.njtrestws.dto.ItemDTO;
import com.wdyc.njtrestws.dto.RepairDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-11-26T21:43:22+0100",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class RepairMapperImpl implements RepairMapper {

    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final ItemMapper itemMapper = new ItemMapperImpl();

    @Override
    public RepairDTO repairEntityToDto(RepairEntity repair) {
        if (repair == null) {
            return null;
        }

        RepairDTO repairDTO = new RepairDTO();

        if (repair.getId() != null) {
            repairDTO.setId(String.valueOf(repair.getId()));
        }
        if (repair.getDatum() != null) {
            repairDTO.setDatum(repair.getDatum().toString());
        }
        repairDTO.setKilometers(String.valueOf(repair.getKilometers()));
        repairDTO.setIsActive(repair.getIsActive());
        if (repair.getPrice() != null) {
            repairDTO.setPrice(String.valueOf(repair.getPrice()));
        }
        repairDTO.setCar(carMapper.carEntityToDto(repair.getCar()));
        repairDTO.setShop(userMapper.userEntityToDto(repair.getShop()));
        repairDTO.setItemList(itemEntityListToItemDTOList(repair.getItemList()));

        return repairDTO;
    }

    @Override
    public RepairEntity repairDtoToEntity(RepairDTO repair) {
        if (repair == null) {
            return null;
        }

        RepairEntity repairEntity = new RepairEntity();

        if (repair.getId() != null) {
            repairEntity.setId(Integer.parseInt(repair.getId()));
        }
        if (repair.getDatum() != null) {
            repairEntity.setDatum(LocalDate.parse(repair.getDatum()));
        }
        if (repair.getKilometers() != null) {
            repairEntity.setKilometers(Integer.parseInt(repair.getKilometers()));
        }
        repairEntity.setIsActive(repair.isIsActive());
        if (repair.getPrice() != null) {
            repairEntity.setPrice(Double.parseDouble(repair.getPrice()));
        }
        repairEntity.setCar(carMapper.carDtoToEntity(repair.getCar()));
        repairEntity.setShop(userMapper.userDtoToEntity(repair.getShop()));
        for (ItemDTO item : repair.getItemList()) {
            repairEntity.addItem(itemMapper.itemDtoToEntity(item));
        }

        return repairEntity;
    }

    protected List<ItemDTO> itemEntityListToItemDTOList(List<ItemEntity> list) {
        if (list == null) {
            return null;
        }

        List<ItemDTO> list1 = new ArrayList<ItemDTO>(list.size());
        for (ItemEntity itemEntity : list) {
            list1.add(itemMapper.itemEntityToDto(itemEntity));
        }

        return list1;
    }

}
