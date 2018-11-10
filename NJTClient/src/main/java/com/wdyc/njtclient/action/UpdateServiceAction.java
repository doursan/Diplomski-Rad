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
public class UpdateServiceAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String id = request.getParameter("services");
        String name = request.getParameter("name");
        String hours = request.getParameter("hours");
        String price = request.getParameter("price");

        if (name.isEmpty()) {
            request.setAttribute("message", "Name field can not be empty!");
            ChangeServiceAction changeServiceAction = new ChangeServiceAction();
            return changeServiceAction.execute(request);
        }
        ServiceDTO service = new ServiceDTO();
        service.setName(name);

        if (!(hours.isEmpty() || hours.equalsIgnoreCase("Hours not available!"))) {
            service.setHours(hours);
        }

        if (!(price.isEmpty() || price.equalsIgnoreCase("Price not available!"))) {
            service.setPrice(price);
        }

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
