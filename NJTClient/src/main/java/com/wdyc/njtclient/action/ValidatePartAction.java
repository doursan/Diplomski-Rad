/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.validation.PartValidator;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class ValidatePartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String value = request.getParameter("value");
        String attribute = request.getParameter("attribute");
        String perform = request.getParameter("perform");
        
        if (attribute.equalsIgnoreCase("name")) {
            return validate(PartValidator.getInstance().validateName(value, perform));
        }
        if (attribute.equalsIgnoreCase("price")) {
            return validate(PartValidator.getInstance().validatePrice(value));
        }
        
        return "<span style='font-size:100px;'>&#10060;</span>";
    }
    
    private String validate(boolean valid) {
        if (valid) {
            return "<span style='font-size:20px;'>&#9989;</span>";
        } else {
            return "<span style='font-size:20px;'>&#10060;</span>";
        }
    }
    
}
