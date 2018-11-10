/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class AddCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        request.setAttribute("banner_page", "/WEB-INF/pages/save_part_form.jsp");
        return "add_part";
        
    }
    
}
