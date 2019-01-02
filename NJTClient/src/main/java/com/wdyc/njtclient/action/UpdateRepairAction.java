/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ItemDTO;
import com.wdyc.njtclient.dto.RepairDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class UpdateRepairAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        String kilometers = request.getParameter("kilometers");
        
        RepairDTO repair = AddRepairItemAction.getRepair();
        repair.setKilometers(kilometers);
        
        
        RestWSClient.getInstance().setTarget(Constants.REPAIRS_PATH);
        Response response = RestWSClient.getInstance().updateById_JSON(repair, repair.getId());
        if(response.getStatus() == 200) {
            RepairDTO updatedRepair = response.readEntity(RepairDTO.class);
            request.setAttribute("message", "You have successfully updated a repair with id: "+updatedRepair.getId());
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";        
    }
    
}
