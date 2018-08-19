/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmd.wdyc.action;

import com.dmd.wdyc.ws.service.user.Exception_Exception;
import com.dmd.wdyc.ws.service.user.UserEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dusan
 */
public class LoginAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            UserEntity user = login(username, password);
            HttpSession session = request.getSession(true);
            session.setAttribute("logged_user", user);
            if (user.getType().equalsIgnoreCase("S")) {
                return "admin";
            } else {
                return "index";
            }
        } catch (Exception_Exception ex) {            
            request.setAttribute("errorMessage", ex.getMessage());
            return "login";
        }       
    }

    private static UserEntity login(java.lang.String arg0, java.lang.String arg1) throws Exception_Exception {
        com.dmd.wdyc.ws.service.user.UserWS_Service service = new com.dmd.wdyc.ws.service.user.UserWS_Service();
        com.dmd.wdyc.ws.service.user.UserWS port = service.getUserWSPort();
        return port.login(arg0, arg1);
    }
}
