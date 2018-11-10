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
public class SaveServiceAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String hours = request.getParameter("hours");
        String price = request.getParameter("price");

        ServiceDTO service = new ServiceDTO();
        service.setName(name);
        if (!hours.isEmpty()) {
            service.setHours(hours);
        }
        if (!price.isEmpty()) {
            service.setPrice(price);
        }

        RestWSClient.getInstance().setTarget(Constants.SERVICES_PATH);
        Response response = RestWSClient.getInstance().create_JSON(service);
        if (response.getStatus() == 201) {
            ServiceDTO returnedService = response.readEntity(ServiceDTO.class);

            request.setAttribute("message", "You have successfully saved a service!");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }
}
