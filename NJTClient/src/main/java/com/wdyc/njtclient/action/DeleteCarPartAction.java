/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarPartDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class DeleteCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        RestWSClient.getInstance().setTarget(Constants.CAR_PARTS_PATH);
        Response response = RestWSClient.getInstance().getAll_JSON();

        if (response.getStatus() == 200) {
            List<CarPartDTO> carParts = response.readEntity(new GenericType<List<CarPartDTO>>() {});

            request.setAttribute("car_parts", carParts);
            request.setAttribute("banner_page", "/WEB-INF/pages/delete_part_form.jsp");

            return "delete_part";
        } else {
            String poruka = response.readEntity(String.class);
            request.setAttribute("message", poruka);
            return "admin";
        }
    }

}
