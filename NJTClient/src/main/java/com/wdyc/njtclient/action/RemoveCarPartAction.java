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
public class RemoveCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("part_id");
        System.out.println("Id je :"+id);        
        
        RestWSClient.getInstance().setTarget(Constants.CAR_PARTS_PATH);
        Response response = RestWSClient.getInstance().delete_JSON(id);
        
        if(response.getStatus() == 200) {
            CarPartDTO deletedCarPart = response.readEntity(CarPartDTO.class);
            request.setAttribute("message", "Automobilski deo je uspesno obrisan!");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", "Doslo je do greske prilikom brisanja automobilskog dela!");
        }
        return "admin";
    }
    
}
