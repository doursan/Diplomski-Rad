/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarDTO;
import com.wdyc.njtclient.dto.ClientDTO;
import com.wdyc.njtclient.dto.ModelEngineDTO;
import com.wdyc.njtclient.dto.UserDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class SaveCarAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String vin = request.getParameter("vin");
        String registration = request.getParameter("registration");
        String carBrandId = request.getParameter("car_brands");
        String brandModelId = request.getParameter("car_models");
        String modelEngineId = request.getParameter("engines");
        String productionYear = request.getParameter("production_year");

        HttpSession session = request.getSession();
        String clientId = ((UserDTO) session.getAttribute("logged_user")).getId();

        ClientDTO client = new ClientDTO();
        client.setId(clientId);

        ModelEngineDTO modelEngine = new ModelEngineDTO();
        modelEngine.setId(modelEngineId);

        CarDTO car = new CarDTO();
        car.setOwner(client);
        car.setModelEngine(modelEngine);
        car.setProductionYear(productionYear);
        car.setRegistration(registration);
        car.setVin(vin);

        RestWSClient.getInstance().setTarget(Constants.CAR_PATH);
        Response response = RestWSClient.getInstance().create_JSON(car);
        if (response.getStatus() == 201) {
            CarDTO returnedCar = response.readEntity(CarDTO.class);

            request.setAttribute("message", "You have successfully saved your car");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "index";            
    }
}
