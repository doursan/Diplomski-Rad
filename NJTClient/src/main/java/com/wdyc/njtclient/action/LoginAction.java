/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.UserDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dusan
 */
public class LoginAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        if(request.getSession(false)==null) {
            request.setAttribute("errorMessage", "Your session has expired!");
            return "login";
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        RestWSClient.getInstance().setTarget(Constants.USERS_PATH);

        try {
            UserDTO returnedUser = RestWSClient.getInstance().getByParameter_JSON(UserDTO.class, Constants.USER_USERNAME_PARAM, username);
            if (!returnedUser.getPassword().equals(password)) {
                request.setAttribute("errorMessage", "Invalid username or password");
                return "login";
            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute("logged_user", returnedUser);
                if (returnedUser.getTip().equalsIgnoreCase("S")) {
                    return "admin";
                } else {
                    return "index";
                }
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Invalid username or password");
            return "login";
        }

    }
}
