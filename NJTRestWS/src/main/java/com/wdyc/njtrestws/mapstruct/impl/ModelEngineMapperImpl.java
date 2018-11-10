package com.wdyc.njtrestws.mapstruct.impl;

import com.wdyc.njtrestws.mapstruct.*;
import com.wdyc.njtrestws.domen.CarBrandEntity;
import com.wdyc.njtrestws.domen.CarBrandModelEntity;
import com.wdyc.njtrestws.domen.CarEntity;
import com.wdyc.njtrestws.domen.CarPartEntity;
import com.wdyc.njtrestws.domen.ClientEntity;
import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.ItemEntityPK;
import com.wdyc.njtrestws.domen.ModelEngineEntity;
import com.wdyc.njtrestws.domen.RepairEntity;
import com.wdyc.njtrestws.domen.ServiceEntity;
import com.wdyc.njtrestws.domen.ShopEntity;
import com.wdyc.njtrestws.dto.CarBrandDTO;
import com.wdyc.njtrestws.dto.CarBrandModelDTO;
import com.wdyc.njtrestws.dto.CarDTO;
import com.wdyc.njtrestws.dto.CarPartDTO;
import com.wdyc.njtrestws.dto.ClientDTO;
import com.wdyc.njtrestws.dto.ItemDTO;
import com.wdyc.njtrestws.dto.ItemDTOPK;
import com.wdyc.njtrestws.dto.ModelEngineDTO;
import com.wdyc.njtrestws.dto.RepairDTO;
import com.wdyc.njtrestws.dto.ServiceDTO;
import com.wdyc.njtrestws.dto.ShopDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-10-08T16:24:08+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class ModelEngineMapperImpl implements ModelEngineMapper {

    private final EngineMapper engineMapper = Mappers.getMapper( EngineMapper.class );

    @Override
    public ModelEngineDTO modelEngineEntityToDto(ModelEngineEntity modelEngine) {
        if ( modelEngine == null ) {
            return null;
        }

        ModelEngineDTO modelEngineDTO = new ModelEngineDTO();

        if ( modelEngine.getId() != null ) {
            modelEngineDTO.setId( String.valueOf( modelEngine.getId() ) );
        }
        modelEngineDTO.setEngine( engineMapper.engineEntityToDto( modelEngine.getEngine() ) );

        return modelEngineDTO;
    }

    @Override
    public ModelEngineEntity modelEngineDtoToEntity(ModelEngineDTO modelEngine) {
        if ( modelEngine == null ) {
            return null;
        }

        ModelEngineEntity modelEngineEntity = new ModelEngineEntity();

        if ( modelEngine.getId() != null ) {
            modelEngineEntity.setId( Integer.parseInt( modelEngine.getId() ) );
        }
        modelEngineEntity.setCarEntityList( carDTOListToCarEntityList( modelEngine.getCarEntityList() ) );
        modelEngineEntity.setEngine( engineMapper.engineDtoToEntity( modelEngine.getEngine() ) );
        modelEngineEntity.setModel( carBrandModelDTOToCarBrandModelEntity( modelEngine.getModel() ) );

        return modelEngineEntity;
    }

    protected List<CarEntity> carDTOListToCarEntityList(List<CarDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarEntity> list1 = new ArrayList<CarEntity>( list.size() );
        for ( CarDTO carDTO : list ) {
            list1.add( carDTOToCarEntity( carDTO ) );
        }

        return list1;
    }

    protected ClientEntity clientDTOToClientEntity(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        if ( clientDTO.getId() != null ) {
            clientEntity.setId( Integer.parseInt( clientDTO.getId() ) );
        }
        clientEntity.setUsername( clientDTO.getUsername() );
        clientEntity.setPassword( clientDTO.getPassword() );
        clientEntity.setEmail( clientDTO.getEmail() );
        clientEntity.setTip( clientDTO.getTip() );
        clientEntity.setIme( clientDTO.getIme() );
        clientEntity.setPrezime( clientDTO.getPrezime() );
        clientEntity.setJmbg( clientDTO.getJmbg() );
        clientEntity.setCarList( carDTOListToCarEntityList( clientDTO.getCarList() ) );

        return clientEntity;
    }

    protected List<RepairEntity> repairDTOListToRepairEntityList(List<RepairDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<RepairEntity> list1 = new ArrayList<RepairEntity>( list.size() );
        for ( RepairDTO repairDTO : list ) {
            list1.add( repairDTOToRepairEntity( repairDTO ) );
        }

        return list1;
    }

    protected ShopEntity shopDTOToShopEntity(ShopDTO shopDTO) {
        if ( shopDTO == null ) {
            return null;
        }

        ShopEntity shopEntity = new ShopEntity();

        if ( shopDTO.getId() != null ) {
            shopEntity.setId( Integer.parseInt( shopDTO.getId() ) );
        }
        shopEntity.setUsername( shopDTO.getUsername() );
        shopEntity.setPassword( shopDTO.getPassword() );
        shopEntity.setEmail( shopDTO.getEmail() );
        shopEntity.setTip( shopDTO.getTip() );
        shopEntity.setNaziv( shopDTO.getNaziv() );
        shopEntity.setPib( shopDTO.getPib() );
        shopEntity.setMaticni( shopDTO.getMaticni() );
        shopEntity.setRepairList( repairDTOListToRepairEntityList( shopDTO.getRepairList() ) );

        return shopEntity;
    }

    protected ItemEntityPK itemDTOPKToItemEntityPK(ItemDTOPK itemDTOPK) {
        if ( itemDTOPK == null ) {
            return null;
        }

        ItemEntityPK itemEntityPK = new ItemEntityPK();

        if ( itemDTOPK.getId() != null ) {
            itemEntityPK.setId( Integer.parseInt( itemDTOPK.getId() ) );
        }
        if ( itemDTOPK.getRepairId() != null ) {
            itemEntityPK.setRepairId( Integer.parseInt( itemDTOPK.getRepairId() ) );
        }

        return itemEntityPK;
    }

    protected List<ItemEntity> itemDTOListToItemEntityList(List<ItemDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemEntity> list1 = new ArrayList<ItemEntity>( list.size() );
        for ( ItemDTO itemDTO : list ) {
            list1.add( itemDTOToItemEntity( itemDTO ) );
        }

        return list1;
    }

    protected CarPartEntity carPartDTOToCarPartEntity(CarPartDTO carPartDTO) {
        if ( carPartDTO == null ) {
            return null;
        }

        CarPartEntity carPartEntity = new CarPartEntity();

        if ( carPartDTO.getId() != null ) {
            carPartEntity.setId( Integer.parseInt( carPartDTO.getId() ) );
        }
        carPartEntity.setName( carPartDTO.getName() );
        carPartEntity.setItemList( itemDTOListToItemEntityList( carPartDTO.getItemList() ) );

        return carPartEntity;
    }

    protected ServiceEntity serviceDTOToServiceEntity(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        ServiceEntity serviceEntity = new ServiceEntity();

        if ( serviceDTO.getId() != null ) {
            serviceEntity.setId( Integer.parseInt( serviceDTO.getId() ) );
        }
        if ( serviceDTO.getHours() != null ) {
            serviceEntity.setHours( Double.parseDouble( serviceDTO.getHours() ) );
        }
        if ( serviceDTO.getPrice() != null ) {
            serviceEntity.setPrice( Double.parseDouble( serviceDTO.getPrice() ) );
        }
        serviceEntity.setName( serviceDTO.getName() );
        serviceEntity.setItemList( itemDTOListToItemEntityList( serviceDTO.getItemList() ) );

        return serviceEntity;
    }

    protected ItemEntity itemDTOToItemEntity(ItemDTO itemDTO) {
        if ( itemDTO == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setItemPK( itemDTOPKToItemEntityPK( itemDTO.getItemPK() ) );
        if ( itemDTO.getAmount() != null ) {
            itemEntity.setAmount( Double.parseDouble( itemDTO.getAmount() ) );
        }
        if ( itemDTO.getPrice() != null ) {
            itemEntity.setPrice( Double.parseDouble( itemDTO.getPrice() ) );
        }
        itemEntity.setCarPart( carPartDTOToCarPartEntity( itemDTO.getCarPart() ) );
        itemEntity.setService( serviceDTOToServiceEntity( itemDTO.getService() ) );

        return itemEntity;
    }

    protected RepairEntity repairDTOToRepairEntity(RepairDTO repairDTO) {
        if ( repairDTO == null ) {
            return null;
        }

        RepairEntity repairEntity = new RepairEntity();

        if ( repairDTO.getId() != null ) {
            repairEntity.setId( Integer.parseInt( repairDTO.getId() ) );
        }
        repairEntity.setDatum( repairDTO.getDatum() );
        if ( repairDTO.getKilometers() != null ) {
            repairEntity.setKilometers( Integer.parseInt( repairDTO.getKilometers() ) );
        }
        repairEntity.setIsActive( repairDTO.isIsActive() );
        if ( repairDTO.getPrice() != null ) {
            repairEntity.setPrice( Double.parseDouble( repairDTO.getPrice() ) );
        }
        repairEntity.setCar( carDTOToCarEntity( repairDTO.getCar() ) );
        repairEntity.setShop( shopDTOToShopEntity( repairDTO.getShop() ) );
        repairEntity.setItemList( itemDTOListToItemEntityList( repairDTO.getItemList() ) );

        return repairEntity;
    }

    protected CarEntity carDTOToCarEntity(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        if ( carDTO.getId() != null ) {
            carEntity.setId( Integer.parseInt( carDTO.getId() ) );
        }
        carEntity.setVin( carDTO.getVin() );
        carEntity.setRegistration( carDTO.getRegistration() );
        if ( carDTO.getProductionYear() != null ) {
            carEntity.setProductionYear( Short.parseShort( carDTO.getProductionYear() ) );
        }
        carEntity.setOwner( clientDTOToClientEntity( carDTO.getOwner() ) );
        carEntity.setModelEngine( modelEngineDtoToEntity( carDTO.getModelEngine() ) );
        carEntity.setColor( carDTO.getColor() );
        carEntity.setRepairList( repairDTOListToRepairEntityList( carDTO.getRepairList() ) );

        return carEntity;
    }

    protected List<CarBrandModelEntity> carBrandModelDTOListToCarBrandModelEntityList(List<CarBrandModelDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CarBrandModelEntity> list1 = new ArrayList<CarBrandModelEntity>( list.size() );
        for ( CarBrandModelDTO carBrandModelDTO : list ) {
            list1.add( carBrandModelDTOToCarBrandModelEntity( carBrandModelDTO ) );
        }

        return list1;
    }

    protected CarBrandEntity carBrandDTOToCarBrandEntity(CarBrandDTO carBrandDTO) {
        if ( carBrandDTO == null ) {
            return null;
        }

        CarBrandEntity carBrandEntity = new CarBrandEntity();

        if ( carBrandDTO.getId() != null ) {
            carBrandEntity.setId( Integer.parseInt( carBrandDTO.getId() ) );
        }
        carBrandEntity.setName( carBrandDTO.getName() );
        carBrandEntity.setCountry( carBrandDTO.getCountry() );
        carBrandEntity.setCarBrandModelList( carBrandModelDTOListToCarBrandModelEntityList( carBrandDTO.getCarBrandModelList() ) );

        return carBrandEntity;
    }

    protected List<ModelEngineEntity> modelEngineDTOListToModelEngineEntityList(List<ModelEngineDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ModelEngineEntity> list1 = new ArrayList<ModelEngineEntity>( list.size() );
        for ( ModelEngineDTO modelEngineDTO : list ) {
            list1.add( modelEngineDtoToEntity( modelEngineDTO ) );
        }

        return list1;
    }

    protected CarBrandModelEntity carBrandModelDTOToCarBrandModelEntity(CarBrandModelDTO carBrandModelDTO) {
        if ( carBrandModelDTO == null ) {
            return null;
        }

        CarBrandModelEntity carBrandModelEntity = new CarBrandModelEntity();

        if ( carBrandModelDTO.getId() != null ) {
            carBrandModelEntity.setId( Integer.parseInt( carBrandModelDTO.getId() ) );
        }
        carBrandModelEntity.setName( carBrandModelDTO.getName() );
        if ( carBrandModelDTO.getProductionBegan() != null ) {
            carBrandModelEntity.setProductionBegan( Short.parseShort( carBrandModelDTO.getProductionBegan() ) );
        }
        if ( carBrandModelDTO.getProductionEnd() != null ) {
            carBrandModelEntity.setProductionEnd( Short.parseShort( carBrandModelDTO.getProductionEnd() ) );
        }
        carBrandModelEntity.setCarBrand( carBrandDTOToCarBrandEntity( carBrandModelDTO.getCarBrand() ) );
        carBrandModelEntity.setModelEngineList( modelEngineDTOListToModelEngineEntityList( carBrandModelDTO.getModelEngineList() ) );

        return carBrandModelEntity;
    }
}
