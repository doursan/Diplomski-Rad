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
public class SaveCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String name = request.getParameter("name");
        String price = request.getParameter("price");

        if (price.contains("€")) {
            price = price.replace("€", "");
        }

        CarPartDTO carPart = new CarPartDTO();
        carPart.setName(name);
        carPart.setPrice(price);

        if (!PartValidator.getInstance().validatePart(carPart, "add")) {
            request.setAttribute("message", "Invalid car part");
            request.setAttribute("car_part", carPart);
            request.setAttribute("invalid", true);
            return "add_part";
        }

        request.setAttribute("invalid", false);

        RestWSClient.getInstance().setTarget(Constants.CAR_PARTS_PATH);
        Response response = RestWSClient.getInstance().create_JSON(carPart);
        if (response.getStatus() == 201) {
            CarPartDTO returnedCarPart = response.readEntity(CarPartDTO.class);

            request.setAttribute("message", "You have successfully saved a car part!");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }

}
