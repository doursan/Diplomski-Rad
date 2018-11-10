/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ServiceDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class RemoveServiceAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("services");
        
        if(id.equalsIgnoreCase("Select a service")) {
            request.setAttribute("message", "Please select a car part you want to delete");
            DeleteServiceAction deleteServicesAction = new DeleteServiceAction();
            return deleteServicesAction.execute(request);
        }
        
        RestWSClient.getInstance().setTarget(Constants.SERVICES_PATH);
        Response response = RestWSClient.getInstance().delete_JSON(id);
        
        if(response.getStatus() == 200) {
            ServiceDTO deletedService = response.readEntity(ServiceDTO.class);
            request.setAttribute("message", "You have successfully deleted a service named: "+deletedService.getName());
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }
    
}
