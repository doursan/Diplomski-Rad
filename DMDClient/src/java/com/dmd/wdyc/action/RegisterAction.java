/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmd.wdyc.action;

import com.dmd.wdyc.ws.service.user.Exception_Exception;
import com.dmd.wdyc.ws.service.user.Register;
import com.dmd.wdyc.ws.service.user.UserEntity;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dusan
 */
public class RegisterAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String naziv = "";
        String pib = "";
        String maticni = "";
        String ime = "";
        String prezime = "";
        String jmbg = "";
        if (request.getParameterMap().containsKey("pib")) {
            naziv = request.getParameter("shop-naziv");
            pib = request.getParameter("pib");
            maticni = request.getParameter("maticni");
        } else {
            ime = request.getParameter("ime");
            prezime = request.getParameter("prezime");
            jmbg = request.getParameter("jmbg");
        }

        try {
            UserEntity user = register(username, password, email, naziv, pib, maticni, ime, prezime, jmbg);
            HttpSession session = request.getSession(true);
            session.setAttribute("logged_user", user);
            if (request.getParameterMap().containsKey("pib")) {
                return "admin";
            } else {
                return "index";
            }
        } catch (Exception_Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return "register";
        }

    }

    private static UserEntity register(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7, java.lang.String arg8) throws Exception_Exception {
        com.dmd.wdyc.ws.service.user.UserWS_Service service = new com.dmd.wdyc.ws.service.user.UserWS_Service();
        com.dmd.wdyc.ws.service.user.UserWS port = service.getUserWSPort();
        return port.register(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
}
