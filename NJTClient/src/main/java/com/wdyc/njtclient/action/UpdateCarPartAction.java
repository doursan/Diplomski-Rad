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
public class UpdateCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String id = request.getParameter("parts");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        
        if(name.isEmpty()) {
            request.setAttribute("message", "Name field can not be empty!");
            ChangeCarPartAction changeCarPartAction = new ChangeCarPartAction();
            return changeCarPartAction.execute(request);
        }

        CarPartDTO carPart = new CarPartDTO();
        carPart.setName(name);
        carPart.setPrice(price);

        RestWSClient.getInstance().setTarget(Constants.CAR_PARTS_PATH);
        Response response = RestWSClient.getInstance().updateById_JSON(carPart, id);
        if (response.getStatus() == 200) {
            CarPartDTO updatedCarPart = response.readEntity(CarPartDTO.class);
            request.setAttribute("message", "You have successfully updated a car part with id: " + updatedCarPart.getId());
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }
}