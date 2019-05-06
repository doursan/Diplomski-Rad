/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarBrandDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class AddCarAction extends AbstractAction {    
    
    @Override
    public String execute(HttpServletRequest request) {

        RestWSClient.getInstance().setTarget(Constants.BRANDS_PATH);
        Response response = RestWSClient.getInstance().getAll_JSON();
        List<CarBrandDTO> brands = response.readEntity(new GenericType<List<CarBrandDTO>>() { });
        
        request.setAttribute("car_brands", brands);
        return "add_car";
    }
}
