/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class RemoveItemAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        int rowNumber = Integer.parseInt(request.getParameter("rowNumber"));
        String from = request.getParameter("from");

        AddRepairItemAction.removeItem(rowNumber);
        AddRepairAction addRepairAction = new AddRepairAction();

        if (from.equalsIgnoreCase("update_repair")) {
            addRepairAction.execute(request);
            request.setAttribute("banner_page", "/WEB-INF/pages/update_repair_form.jsp");
            request.setAttribute("repair", AddRepairItemAction.getRepair());
            return "update_repair";
        } else {
            return addRepairAction.execute(request);
        }

    }

}
