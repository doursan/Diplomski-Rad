/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ServiceDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import com.wdyc.njtclient.validation.ServiceValidator;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class UpdateServiceAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String id = request.getParameter("service_id");
        String name = request.getParameter("name");
        String hours = request.getParameter("hours");
        String price = request.getParameter("price");
        String rowIndex = request.getParameter("rowIndex");
        
        ServiceDTO service = new ServiceDTO();
        service.setName(name);
        service.setHours(hours);
        service.setPrice(price);
        
        if (!ServiceValidator.getInstance().validateService(service, "update")) {
            request.setAttribute("message", "Invalid service");
            request.setAttribute("service", service);
            request.setAttribute("index", rowIndex);
            request.setAttribute("invalid", true);
            ChangeServiceAction changeServiceAction = new ChangeServiceAction();
            return changeServiceAction.execute(request);
        }

        request.setAttribute("invalid", false);

        RestWSClient.getInstance().setTarget(Constants.SERVICES_PATH);
        Response response = RestWSClient.getInstance().updateById_JSON(service, id);
        if (response.getStatus() == 200) {
            ServiceDTO updatedService = response.readEntity(ServiceDTO.class);
            request.setAttribute("message", "You have successfully updated a service with id: " + updatedService.getId());
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }

}
