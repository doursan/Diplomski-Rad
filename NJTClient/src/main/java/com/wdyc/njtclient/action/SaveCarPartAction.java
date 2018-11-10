/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarPartDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class SaveCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        
        CarPartDTO carPart = new CarPartDTO();
        carPart.setName(name);
        if(!price.isEmpty()) {
            carPart.setPrice(price);
        }
        
        RestWSClient.getInstance().setTarget(Constants.CAR_PARTS_PATH);
        Response response = RestWSClient.getInstance().create_JSON(carPart);
        if(response.getStatus() == 201) {
            CarPartDTO returnedCarPart = response.readEntity(CarPartDTO.class);
            
            request.setAttribute("message", "You have successfully saved a car part!");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }
    
}
