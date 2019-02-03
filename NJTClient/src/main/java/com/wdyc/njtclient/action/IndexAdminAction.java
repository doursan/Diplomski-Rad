/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class IndexAdminAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        if(request.getSession(false).getAttribute("logged_user") == null) {
            request.setAttribute("errorMessage", "Your session has expired!");
            return "login";
        }
        
        return "admin";
    }
    
}
