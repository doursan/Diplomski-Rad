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
public class FinishRepairAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String repairId = request.getParameter("repair_id");
        
        RepairDTO repair = new RepairDTO();
        repair.setId(repairId);
        repair.setIsActive(false);
        
        RestWSClient.getInstance().setTarget(Constants.REPAIRS_PATH);
        Response response = RestWSClient.getInstance().updateById_JSON(repair, repairId);
        
        if(response.getStatus() == 200) {
            RepairDTO updatedRepair = response.readEntity(RepairDTO.class);
            request.setAttribute("message", "Doslo je do greske prilikom zavrsavanja popravke automobila!");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";    
    }
    
}
