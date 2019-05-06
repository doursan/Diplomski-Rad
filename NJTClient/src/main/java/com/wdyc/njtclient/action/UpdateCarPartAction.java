/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarPartDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import com.wdyc.njtclient.validation.PartValidator;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class UpdateCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String id = request.getParameter("part_id");
        String name = request.getParameter("name");
        String price = request.getParameter("price"); 
        String rowIndex = request.getParameter("rowIndex");

        CarPartDTO carPart = new CarPartDTO();
        carPart.setId(id);
        carPart.setName(name);
        carPart.setPrice(price);
        
        if (!PartValidator.getInstance().validatePart(carPart, "update")) {
            request.setAttribute("message", "Invalid car part");
            request.setAttribute("car_part", carPart);
            request.setAttribute("index", rowIndex);
            request.setAttribute("invalid", true);
            ChangeCarPartAction changeCarPartAction = new ChangeCarPartAction();
            return changeCarPartAction.execute(request);
        }

        request.setAttribute("invalid", false);
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
