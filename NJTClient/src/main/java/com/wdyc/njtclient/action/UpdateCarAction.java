/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class UpdateCarAction extends AbstractAction{

    @Override
    public String execute(HttpServletRequest request) {
        String carId = request.getParameter("cars");
        String registration = request.getParameter("registration");
        String color = request.getParameter("color"); 
        
        CarDTO car = new CarDTO();
        car.setId(carId);
        car.setRegistration(registration);
        car.setColor(color);
        
        RestWSClient.getInstance().setTarget(Constants.CARS_PATH);
        Response response = RestWSClient.getInstance().update_JSON(car);
        if(response.getStatus() == 200) {
            CarDTO updatedCar = response.readEntity(CarDTO.class);            
            request.setAttribute("message", "You have successfully updated your car");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "index";
    }
    
}
