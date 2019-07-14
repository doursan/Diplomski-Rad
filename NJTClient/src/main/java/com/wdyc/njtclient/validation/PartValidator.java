/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.validation;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarPartDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;

/**
 *
 * @author Dusan
 */
public class PartValidator {

    private static PartValidator instance;

    public static PartValidator getInstance() {
        if (instance == null) {
            instance = new PartValidator();
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
                    RestWSClient.getInstance().setTarget(Constants.CAR_PARTS_PATH);
                    RestWSClient.getInstance().getByParameter_JSON(CarPartDTO.class, Constants.PART_NAME_PARAM, name);
                    return false;
                } catch (Exception ex) {
                    return true;
                }
            }
        }
    }

    public boolean validatePrice(String price) {

        if (price.isEmpty()) {
            return true;
        }

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

    public boolean validatePart(CarPartDTO part, String perform) {
        return validateName(part.getName(), perform) && validatePrice(part.getPrice());
    }
}
