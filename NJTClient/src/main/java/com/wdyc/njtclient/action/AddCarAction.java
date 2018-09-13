/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtws.services.CarBrandDTO;
import javax.servlet.http.HttpServletRequest;
import com.wdyc.njtws.services.CarWS_Service;
import com.wdyc.njtws.services.CarWS;
import com.wdyc.njtws.services.CarDTO;
import com.wdyc.njtws.services.EngineDTO;
import java.util.List;
/**
 *
 * @author Dusan
 */
public class AddCarAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        try { // Call Web Service Operation
            CarWS_Service service = new CarWS_Service();
            CarWS port = service.getCarWSPort();
            // TODO process result here
            CarDTO result = port.addCar();
            List<CarBrandDTO> carBrands = result.getBrands();
            List<EngineDTO> engines = result.getEngines();
            System.out.println("Car brands and engines returned. There are "+ carBrands.size() + " car brands and " + engines.size() + " engines.");
            request.setAttribute("car_brands", carBrands);
            request.setAttribute("engines", engines);
            request.setAttribute("banner_page", "/WEB-INF/pages/save_car_form.jsp");
            return "add_car";
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return "index";
        }

    }
    
}
