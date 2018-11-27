/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarDTO;
import com.wdyc.njtclient.dto.ItemDTO;
import com.wdyc.njtclient.dto.RepairDTO;
import com.wdyc.njtclient.dto.UserDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class SaveRepairAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String registration = request.getParameter("registration");
        String kilometers = request.getParameter("kilometers");
        RepairDTO repair = AddRepairItemAction.getRepair();
        Double price = 0.0;
        HttpSession session = request.getSession(true);
        UserDTO shop = (UserDTO) session.getAttribute("logged_user");
        
        try {                   
            RestWSClient.getInstance().setTarget(Constants.CARS_PATH);
            CarDTO returnedCar = RestWSClient.getInstance().getByParameter_JSON(CarDTO.class, Constants.CARS_REGISTRATION_PARAM, registration);

            for (ItemDTO item : repair.getItemList()) {
                price += Double.parseDouble(item.getPrice());
                
            }            
            repair.setCar(returnedCar);
            repair.setIsActive(true);
            repair.setKilometers(kilometers);
            repair.setPrice(String.valueOf(price));
            repair.setShop(shop);

            RestWSClient.getInstance().setTarget(Constants.REPAIRS_PATH);
            Response response = RestWSClient.getInstance().create_JSON(repair);

            if (response.getStatus() == 201) {
                RepairDTO returnedRepair = response.readEntity(RepairDTO.class);

                request.setAttribute("message", "You have successfully created a Repair!");
            } else {
                String errorMessage = response.readEntity(String.class);
                request.setAttribute("message", errorMessage);
            }
            return "admin";
        } catch (Exception ex) {
            request.setAttribute("message", "Invalid registration number!");
            AddRepairAction addRepairAction = new AddRepairAction();
            return addRepairAction.execute(request);
        }
    }
}