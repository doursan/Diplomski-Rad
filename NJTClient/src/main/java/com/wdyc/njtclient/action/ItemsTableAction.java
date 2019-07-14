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
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class ItemsTableAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {

        String repairId = request.getParameter("repair");

        try {
            RestWSClient.getInstance().setTarget(Constants.REPAIRS_PATH);
            RepairDTO returnedRepair = RestWSClient.getInstance().getByParameter_JSON(RepairDTO.class, Constants.REPAIRS_ID_PARAM, repairId);

            String table = "<br/>\n" +
"                                    <br/>\n" +
"                                    <label>Repair Items</label> \n" +
"                                    <br/>\n" +
"                                    <br>  \n" +
"                                    <br>\n" +
"                                    <table id=\"repairItems\" class=\"table dataTabele table-striped\" cellspacing=\"0\" width=\"100%\">\n"
                    + "                                        <thead>\n"
                    + "                                            <tr>\n"
                    + "                                                <th class=\"th-sm\">#</th>\n"
                    + "                                                <th class=\"th-sm\">Name</th>\n"
                    + "                                                <th class=\"th-sm\">Price per unit</th>\n"
                    + "                                                <th class=\"th-sm\">Amount</th>\n"
                    + "                                                <th class=\"th-sm\">Price</th>\n"
                    + "                                            </tr>\n"
                    + "                                        </thead>\n"
                    + "                                        <tbody>\n";

            String rows = "";
            
            Collections.sort(returnedRepair.getItemList(), new Comparator<ItemDTO>() {
                        @Override
                        public int compare(ItemDTO i1, ItemDTO i2) {
                            return i1.getRowNumber() - i2.getRowNumber();
                        }
                    });

            for (ItemDTO item : returnedRepair.getItemList()) {
                rows += "<tr>\n"
                        + "<td>" + item.getRowNumber() + "</td>\n"
                        + "<td>" + item.getName() + "</td>\n"
                        + "<td>" + item.getPricePerUnit() + "</td>\n"
                        + "<td>" + item.getAmount() + "</td>\n"
                        + "<td>" + item.getPrice() + "</td>\n"
                        + "</tr>\n";
            }

            table += rows;
            table += "</tbody>\n"
                    + "<tfoot>\n"
                    + "                                <tr>\n"
                    + "                                                <th class=\"th-sm\">#</th>\n"
                    + "                                                <th class=\"th-sm\">Name</th>\n"
                    + "                                                <th class=\"th-sm\">Price per unit</th>\n"
                    + "                                                <th class=\"th-sm\">Amount</th>\n"
                    + "                                                <th class=\"th-sm\">Price</th>\n"
                    + "                                </tr>\n"
                    + "                            </tfoot>"
                    + "</table>";
            System.out.println(table);

            return table;
        } catch (Exception ex) {
            return "Invalid Repair Selected";
        }
    }

}
