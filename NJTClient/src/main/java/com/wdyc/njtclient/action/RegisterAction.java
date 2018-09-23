/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ClientDTO;
import com.wdyc.njtclient.dto.ShopDTO;
import com.wdyc.njtclient.dto.UserDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

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
        UserDTO user, returnedUser;

        if (request.getParameterMap().containsKey("pib")) {
            String naziv = request.getParameter("shop-naziv");
            String pib = request.getParameter("pib");
            String maticni = request.getParameter("maticni");

            user = new ShopDTO(naziv, pib, maticni, username, password, email);
            RestWSClient.getInstance().setTarget(Constants.SHOPS_PATH);
        } else {
            String ime = request.getParameter("ime");
            String prezime = request.getParameter("prezime");
            String jmbg = request.getParameter("jmbg");

            RestWSClient.getInstance().setTarget(Constants.CLIENTS_PATH);
            user = new ClientDTO(ime, prezime, jmbg, username, password, email);
        }
        Response response = RestWSClient.getInstance().create_JSON(user);
        HttpSession session = request.getSession(true);

        if (response.getStatusInfo().getStatusCode() == 201) {
            if (user instanceof ClientDTO) {
                returnedUser = response.readEntity(ClientDTO.class);
                session.setAttribute("logged_user", returnedUser);
                return "index";
            } else {
                returnedUser = response.readEntity(ShopDTO.class);
                session.setAttribute("logged_user", returnedUser);
                return "admin";
            }
        } else {
            request.setAttribute("errorMessage", "Server error! Unable to register user.");
            return "register";
        }
    }

}
