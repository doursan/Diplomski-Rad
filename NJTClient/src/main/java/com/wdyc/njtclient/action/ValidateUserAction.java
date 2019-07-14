/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.validation.UserValidator;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class ValidateUserAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String value = request.getParameter("value");
        String attribute = request.getParameter("attribute");

        if (attribute.equalsIgnoreCase("email")) {
            return validate(UserValidator.getInstance().validateEmail(value));
        }
        if (attribute.equalsIgnoreCase("username")) {
            return validate(UserValidator.getInstance().validateUsername(value));
        }
        if (attribute.equalsIgnoreCase("ime") || attribute.equalsIgnoreCase("prezime")) {
            return validate(UserValidator.getInstance().validateFirstOrLastName(value));
        }
        if (attribute.equalsIgnoreCase("jmbg")) {
            return validate(UserValidator.getInstance().validateJmbg(value));
        }
        if (attribute.equalsIgnoreCase("password")) {
            return validate(UserValidator.getInstance().validatePassword(value));
        }
        if (attribute.equalsIgnoreCase("shop-naziv")) {
            return validate(UserValidator.getInstance().validateShopName(value));
        }
        if (attribute.equalsIgnoreCase("pib")) {
            return validate(UserValidator.getInstance().validatePib(value));
        }
        if (attribute.equalsIgnoreCase("maticni")) {
            return validate(UserValidator.getInstance().validateMaticni(value));
        }
        if (attribute.equalsIgnoreCase("buyer")) {
            return validate(UserValidator.getInstance().validateBuyer(value));
        }
        
        return "<span class=\"glyphicon glyphicon-remove\" style=\"color:red\"></span>";
    }
    
    private String validate(boolean valid) {
        if (valid) {
            return "<span class=\"glyphicon glyphicon-ok\" style=\"color:green\"></span>";
        } else {
            return "<span class=\"glyphicon glyphicon-remove\" style=\"color:red\"></span>";
        }
    }
}
