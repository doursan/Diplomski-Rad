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
import com.wdyc.njtclient.validation.RepairValidator;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class UpdateRepairAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        RepairDTO repair = AddRepairItemAction.getRepair();

        String kilometers = request.getParameter("kilometers");
        String registration = repair.getCar().getRegistration();

        repair.setKilometers(kilometers);

        if (!RepairValidator.getInstance().validateRepair(registration, kilometers, "update_repair")) {
            request.setAttribute("message_repair", "Invalid repair");
            request.setAttribute("registration", registration);
            request.setAttribute("kilometers", kilometers);
            request.setAttribute("invalid_repair", true);

            AddRepairAction addRepairAction = new AddRepairAction();
            addRepairAction.execute(request);

            request.setAttribute("banner_page", "/WEB-INF/pages/update_repair_form.jsp");
            request.setAttribute("repair", repair);

            return "update_repair";
        }

        request.setAttribute("invalid", false);

        RestWSClient.getInstance().setTarget(Constants.REPAIRS_PATH);
        Response response = RestWSClient.getInstance().updateById_JSON(repair, repair.getId());
        if (response.getStatus() == 200) {
            RepairDTO updatedRepair = response.readEntity(RepairDTO.class);
            request.setAttribute("message", "Popravka automobila je uspesno izmenjena!");
        } else {
            String errorMessage = response.readEntity(String.class);
            request.setAttribute("message", errorMessage);
        }
        return "admin";
    }

}
