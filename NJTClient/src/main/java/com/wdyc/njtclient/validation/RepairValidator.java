/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.validation;

import com.wdyc.njtclient.dto.ItemDTO;
import com.wdyc.njtclient.dto.RepairDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dusan
 */
public class RepairValidator {
    
    private static RepairValidator instance;

    public static RepairValidator getInstance() {
        if (instance == null) {
            instance = new RepairValidator();
        }
        return instance;
    }
    
    public boolean validateAmount(String amount) {
        
        try {
            double doubleAmount = Double.parseDouble(amount);
            if(doubleAmount > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean validatePrice(String price) {
        if(price.isEmpty()) {
            return true;
        }
        try {
            double doublePrice = Double.parseDouble(price);
            if(doublePrice > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateKilometers(String kilometers) {
        if(kilometers.isEmpty()) {
            return false;
        }
        kilometers = kilometers.trim();
        try {
            int intKilometers = Integer.parseInt(kilometers);
            if(intKilometers > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateItem(ItemDTO item) {
        return validateAmount(item.getAmount()) && validatePrice(item.getPricePerUnit());
    }

    public boolean validateRepair(String registration, String kilometers, String perform) {
        return CarValidator.getInstance().validateRegistration(registration, perform) && validateKilometers(kilometers);
    }  
    
}
