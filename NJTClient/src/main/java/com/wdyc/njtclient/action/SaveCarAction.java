/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtws.services.CarBrandDTO;
import com.wdyc.njtws.services.CarBrandModelDTO;
import com.wdyc.njtws.services.CarDTO;
import com.wdyc.njtws.services.ClientDTO;
import com.wdyc.njtws.services.EngineDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.wdyc.njtws.services.CarWS_Service;
import com.wdyc.njtws.services.CarWS;
import com.wdyc.njtws.services.ModelEngineDTO;
import com.wdyc.njtws.services.UserDTO;

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
        
        try { // Call Web Service Operation
            CarWS_Service service = new CarWS_Service();
            CarWS port = service.getCarWSPort();
            CarDTO result = port.saveCar(car);
            System.out.println("Result = "+result.getRegistration());
            request.setAttribute("message", "You have successfully saved your car");
            return "index";
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            return "index";
        }
    }
}
