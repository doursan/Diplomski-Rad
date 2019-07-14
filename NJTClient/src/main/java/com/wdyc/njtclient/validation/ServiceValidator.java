/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.validation;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ServiceDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;

/**
 *
 * @author Dusan
 */
public class ServiceValidator {

    private static ServiceValidator instance;

    public static ServiceValidator getInstance() {
        if (instance == null) {
            instance = new ServiceValidator();
        }
        return instance;
    }

    public boolean validateName(String name, String perform) {
        if (name.length() < 5) {
            return false;
        } else {
            if (perform.equalsIgnoreCase("update")) {
                return true;
            } else {
                try {
                    RestWSClient.getInstance().setTarget(Constants.SERVICES_PATH);
                    RestWSClient.getInstance().getByParameter_JSON(ServiceDTO.class, Constants.SERVICES_NAME_PARAM, name);
                    return false;
                } catch (Exception ex) {
                    return true;

                }
            }
        }
    }

    public boolean validateHours(String hours) {
        try {
            double doubleHours = Double.parseDouble(hours);
            if (doubleHours > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validatePrice(String price) {
        try {
            double doublePrice = Double.parseDouble(price);
            if (doublePrice > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateService(ServiceDTO service, String perform) {
        return validateName(service.getName(), perform) && validatePrice(service.getPrice()) && validateHours(service.getHours());
    }
}
