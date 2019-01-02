/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.dto.RepairDTO;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class AddRepairAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String action = request.getParameter("action");
        
        ChangeCarPartAction changeCarPartAction = new ChangeCarPartAction();
        String page = changeCarPartAction.execute(request);

        ChangeServiceAction changeServiceAction = new ChangeServiceAction();
        String page2 = changeServiceAction.execute(request);

        if (page.equalsIgnoreCase("admin") || page2.equalsIgnoreCase("admin")) {
            return "admin";
        }
        if(action.equalsIgnoreCase("create_repair")) {
            AddRepairItemAction.setRepair(new RepairDTO());
        }
        
        request.setAttribute("banner_page", "/WEB-INF/pages/save_repair_form.jsp");
        request.setAttribute("items", AddRepairItemAction.getRepair().getItemList());

        return "add_repair";

    }

}
