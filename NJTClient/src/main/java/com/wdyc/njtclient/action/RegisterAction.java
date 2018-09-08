/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtws.services.ClientDTO;
import com.wdyc.njtws.services.ShopDTO;
import com.wdyc.njtws.services.UserWS;
import com.wdyc.njtws.services.UserWS_Service;
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

        if (request.getParameterMap().containsKey("pib")) {
            String naziv = request.getParameter("shop-naziv");
            String pib = request.getParameter("pib");
            String maticni = request.getParameter("maticni");

            ShopDTO shopDTO = new ShopDTO();

            shopDTO.setUsername(username);
            shopDTO.setPassword(password);
            shopDTO.setEmail(email);
            shopDTO.setMaticni(maticni);
            shopDTO.setNaziv(naziv);
            shopDTO.setPib(pib);

            try {
                UserWS_Service service = new UserWS_Service();
                UserWS port = service.getUserWSPort();

                ShopDTO returnedShop = port.registerShop(shopDTO);
                System.out.println("Result = " + returnedShop);
                HttpSession session = request.getSession(true);
                session.setAttribute("logged_user", returnedShop);
                return "admin";
            } catch (Exception ex) {
                request.setAttribute("errorMessage", ex.getMessage());
                return "register";
            }

        } else {
            String ime = request.getParameter("ime");
            String prezime = request.getParameter("prezime");
            String jmbg = request.getParameter("jmbg");

            ClientDTO clientDTO = new ClientDTO();

            clientDTO.setUsername(username);
            clientDTO.setPassword(password);
            clientDTO.setEmail(email);
            clientDTO.setIme(ime);
            clientDTO.setPrezime(prezime);
            clientDTO.setJmbg(jmbg);

            try {
                UserWS_Service service = new UserWS_Service();
                UserWS port = service.getUserWSPort();                
                
                ClientDTO returnedClient = port.registerClient(clientDTO);
                System.out.println("Result = " + returnedClient);
                HttpSession session = request.getSession(true);
                session.setAttribute("logged_user", returnedClient);
                return "index";
            } catch (Exception ex) {
                ex.printStackTrace();
                request.setAttribute("errorMessage", ex.getMessage());
                return "register";
            }
        }
    }

}
