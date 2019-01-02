/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.RepairDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class RemoveRepairAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String repairId = request.getParameter("repair_id");
        
        if(repairId.isEmpty()) {
            request.setAttribute("message", "Please select a repair you want to delete");
            SelectRepairAction changeRepairAction = new SelectRepairAction();
            request.setAttribute("action", "delete_repair");
            return changeRepairAction.execute(request);
        } 
        
        RestWSClient.getInstance().setTarget(Constants.REPAIRS_PATH);
        Response response = RestWSClient.getInstance().delete_JSON(repairId);
        
        if(response.getStatus() == 200) {
            RepairDTO deletedRepair = response.readEntity(RepairDTO.class);
            request.setAttribute("message", "You have successfully deleted a repair with id: "+deletedRepair.getId());
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }
    
}
