/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class AutocompleteRegistrationAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        String partialRegistration = request.getParameter("registration");
        RestWSClient.getInstance().setTarget(Constants.CARS_PATH);
        Response response = RestWSClient.getInstance().getManyByParameter_JSON(Constants.CARS_REGISTRATION_SUGGEST_PARAM, partialRegistration);
        List<CarDTO> cars = new ArrayList<>();
        cars = response.readEntity(new GenericType<List<CarDTO>>() {
        });

        String suggestions = "";

        if (cars.isEmpty()) {
            return "Not a valid registration!";
        } else {
            for (CarDTO car : cars) {
                String line = "<a href=\"#registration\"><div onclick='finish(\"" + car.getRegistration() + "\")'>" + car.getRegistration() + "</div></a>\n";
                suggestions += line;
            }
            System.out.println(suggestions);
            return suggestions;
        }
    }
}
