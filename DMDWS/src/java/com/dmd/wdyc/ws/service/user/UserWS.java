/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmd.wdyc.ws.service.user;

import com.dmd.wdyc.ws.broker.JPABroker;
import com.dmd.wdyc.ws.domen.ClientEntity;
import com.dmd.wdyc.ws.domen.ShopEntity;
import com.dmd.wdyc.ws.domen.UserEntity;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Dusan
 */
@WebService(serviceName = "UserWS")
public class UserWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "login")
    public UserEntity login(String username, String password) throws Exception {
        System.out.println("Pozivam login iz UserWebService");
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);

        return JPABroker.getInstance().findUser(user);
    }

    @WebMethod(operationName = "register")
    public UserEntity register(String username, String password, String email, String naziv, String pib, String maticni, String ime, String prezime, String jmbg) throws Exception {
        System.out.println("Pozivam register iz UserWebService");

        UserEntity user;
        if (!pib.equalsIgnoreCase("")) {
            user = new ShopEntity(naziv, pib, maticni, username, password, email);
        } else {
            user = new ClientEntity(ime, prezime, jmbg, username, password, email);
        }

        return JPABroker.getInstance().saveUser(user);
    }
}
