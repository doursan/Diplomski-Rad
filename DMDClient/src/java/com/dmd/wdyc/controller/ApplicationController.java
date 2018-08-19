/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmd.wdyc.controller;

import com.dmd.wdyc.action.AbstractAction;
import com.dmd.wdyc.action.ActionFactory;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class ApplicationController {

    private static ApplicationController instance;

    private ApplicationController() {
    }

    public static ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
        }
        return instance;
    }
    
    public String processRequest(String action, HttpServletRequest request) {
        String page = "pages/login.jsp";
        
        AbstractAction command = ActionFactory.createAction(action);
        page = command.execute(request);
        
        return page;
    }

}
