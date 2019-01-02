package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.RepairEntity;
import com.wdyc.njtrestws.dto.ItemDTO;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-12-16T00:54:48+0100",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ItemMapperImpl implements ItemMapper {

    private final CarPartMapper carPartMapper = Mappers.getMapper(CarPartMapper.class);
    private final ServiceMapper serviceMapper = Mappers.getMapper(ServiceMapper.class);

    @Override
    public ItemDTO itemEntityToDto(ItemEntity item) {
        if (item == null) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        if (item.getCarPart() != null) {
            itemDTO.setName(item.getCarPart().getName());
        } else {
            itemDTO.setName(item.getService().getName());
        }

        Integer id = itemRepairId(item);
        if (id != null) {
            itemDTO.setRepairId(id);
        }

        itemDTO.setRowNumber(item.getId());
        if (item.getAmount() != null) {
            itemDTO.setAmount(String.valueOf(item.getAmount()));
        }
        if (item.getPrice() != null) {
            itemDTO.setPrice(String.valueOf(item.getPrice()));
        }

        if (item.getPrice() != null && item.getAmount() != null) {
            Double pricePerUnit = item.getPrice()/item.getAmount();
            itemDTO.setPricePerUnit(String.valueOf(pricePerUnit));
        }

        itemDTO.setCarPart(carPartMapper.carPartEntityToDto(item.getCarPart()));
        itemDTO.setService(serviceMapper.serviceEntityToDto(item.getService()));

        return itemDTO;
    }

    @Override
    public ItemEntity itemDtoToEntity(ItemDTO item) {
        if (item == null) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setRepair(itemDTOToRepairEntity(item));
        itemEntity.setId(item.getRowNumber());
        if (item.getAmount() != null) {
            itemEntity.setAmount(Double.parseDouble(item.getAmount()));
        }
        if (item.getPrice() != null) {
            itemEntity.setPrice(Double.parseDouble(item.getPrice()));
        }
        itemEntity.setCarPart(carPartMapper.carPartDtoToEntity(item.getCarPart()));
        itemEntity.setService(serviceMapper.serviceDtoToEntity(item.getService()));

        return itemEntity;
    }

    private Integer itemRepairId(ItemEntity itemEntity) {
        if (itemEntity == null) {
            return null;
        }
        RepairEntity repair = itemEntity.getRepair();
        if (repair == null) {
            return null;
        }
        Integer id = repair.getId();
        if (id == null) {
            return null;
        }
        return id;
    }

    protected RepairEntity itemDTOToRepairEntity(ItemDTO itemDTO) {
        if (itemDTO == null) {
            return null;
        }

        RepairEntity repairEntity = new RepairEntity();

        repairEntity.setId(itemDTO.getRepairId());

        return repairEntity;
    }
}
