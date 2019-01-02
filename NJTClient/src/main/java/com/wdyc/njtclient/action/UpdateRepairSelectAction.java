/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.dto.ItemDTO;
import com.wdyc.njtclient.dto.RepairDTO;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class UpdateRepairSelectAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String repairId = request.getParameter("repairs");

        RepairDTO repairToUpdate = new RepairDTO();

        for (RepairDTO repair : SelectRepairAction.getRepairs()) {
            if (repair.getId().equals(repairId)) {
                repairToUpdate = repair;
            }
        }

        Collections.sort(repairToUpdate.getItemList(), new Comparator<ItemDTO>() {
            @Override
            public int compare(ItemDTO i1, ItemDTO i2) {
                return i1.getRowNumber() - i2.getRowNumber();
            }
        });

        AddRepairItemAction.setRepair(repairToUpdate);

        AddRepairAction addRepairAction = new AddRepairAction();

        addRepairAction.execute(request);

        request.setAttribute("banner_page", "/WEB-INF/pages/update_repair_form.jsp");
        request.setAttribute("repair", repairToUpdate);

        return "update_repair";

    }

}
