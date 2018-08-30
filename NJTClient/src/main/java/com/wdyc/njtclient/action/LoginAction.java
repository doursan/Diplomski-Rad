/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.wdyc.njtws.services.UserDTO;
import com.wdyc.njtws.services.UserWS;
import com.wdyc.njtws.services.UserWS_Service;

/**
 *
 * @author Dusan
 */
public class LoginAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try { // Call Web Service Operation
            UserWS_Service service = new UserWS_Service();
            UserWS port = service.getUserWSPort();
            // TODO process result here
            UserDTO user = new UserDTO();
            user.setUsername(username);
            user.setPassword(password);
            UserDTO returnedUser = port.login(user);
            System.out.println("Result = " + returnedUser.getType());
            HttpSession session = request.getSession(true);
            session.setAttribute("logged_user", returnedUser);
            if (returnedUser.getType().equalsIgnoreCase("S")) {
                return "admin";
            } else {
                return "index";
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return "login";
        }

    }

}
