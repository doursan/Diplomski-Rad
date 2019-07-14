/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarDTO;
import com.wdyc.njtclient.dto.UserDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class SellCarPageAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = ((UserDTO) session.getAttribute("logged_user")).getId();
        RestWSClient.getInstance().setTarget(Constants.CARS_PATH);
        Response response = RestWSClient.getInstance().getManyByParameter_JSON(Constants.CARS_USER_PARAM, userId);
        List<CarDTO> cars = response.readEntity(new GenericType<List<CarDTO>>() { });
        
        request.setAttribute("user_cars", cars);
        return "sell_car";
    }
    
    
    
}
