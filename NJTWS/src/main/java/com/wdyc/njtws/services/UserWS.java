/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.services;

import com.wdyc.njtws.dao.UserDAO;
import com.wdyc.njtws.domen.ClientEntity;
import com.wdyc.njtws.domen.ShopEntity;
import com.wdyc.njtws.domen.UserEntity;
import com.wdyc.njtws.dto.ClientDTO;
import com.wdyc.njtws.dto.ShopDTO;
import com.wdyc.njtws.dto.UserDTO;
import com.wdyc.njtws.mapstruct.ClientMapper;
import com.wdyc.njtws.mapstruct.impl.ClientMapperImpl;
import com.wdyc.njtws.mapstruct.ShopMapper;
import com.wdyc.njtws.mapstruct.impl.ShopMapperImpl;
import com.wdyc.njtws.mapstruct.UserMapper;
import com.wdyc.njtws.mapstruct.impl.UserMapperImpl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dusan
 */
@WebService(serviceName = "UserWS")
public class UserWS {

    UserMapper userMapper = new UserMapperImpl();
    ShopMapper shopMapper = new ShopMapperImpl();
    ClientMapper clientMapper = new ClientMapperImpl();

    UserDAO dao = new UserDAO();

    @WebMethod(operationName = "login")
    public UserDTO login(@WebParam(name = "user") UserDTO userDto) throws Exception {
        System.out.println("Pozivam Login iz Web Servisa");
        UserEntity convertedUser = userMapper.userDtoToEntity(userDto);

        UserEntity retrievedUser = dao.findUser(convertedUser);
        return userMapper.userEntityToDto(retrievedUser);
    }

    @WebMethod(operationName = "registerShop")
    public ShopDTO registerShop(@WebParam(name = "shopDTO") ShopDTO shopDto) throws Exception {
        System.out.println("Pozivam Register Shop iz Web Servisa");

        UserEntity convertedUser = shopMapper.shopDtoToEntity((ShopDTO) shopDto);
        UserEntity registredUser = dao.registerUser(convertedUser);
        return shopMapper.shopEntityToDto((ShopEntity) registredUser);

    }

    @WebMethod(operationName = "registerClient")
    public ClientDTO registerClient(@WebParam(name = "clientDTO") ClientDTO clientDto) throws Exception {
        System.out.println("Pozivam Register Client iz Web Servisa");

        UserEntity convertedUser = clientMapper.clientDtoToEntity((ClientDTO) clientDto);
        UserEntity registredUser = dao.registerUser(convertedUser);
        return clientMapper.clientEntityToDto((ClientEntity) registredUser);
    }
}
