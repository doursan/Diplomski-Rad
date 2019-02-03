/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ServiceDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class ChangeServiceAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        RestWSClient.getInstance().setTarget(Constants.SERVICES_PATH);
        Response response = RestWSClient.getInstance().getAll_JSON();
        String action = request.getParameter("action");

        if (response.getStatus() == 200) {
            List<ServiceDTO> services = response.readEntity(new GenericType<List<ServiceDTO>>() {
            });

            request.setAttribute("services", services);
            if (action.equalsIgnoreCase("change_service")) {
                request.setAttribute("banner_page", "/WEB-INF/pages/update_service_form.jsp");
                return "update_service";
            } else {
                request.setAttribute("banner_page", "/WEB-INF/pages/view_services_form.jsp");
                return "view_services";
            }
        } else {
            String poruka = response.readEntity(String.class);
            request.setAttribute("message", poruka);
            if (action.equalsIgnoreCase("change_service")) {
                return "admin";
            } else {
                return "index";
            }
        }
    }

}
