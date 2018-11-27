/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.dto.CarPartDTO;
import com.wdyc.njtclient.dto.ItemDTO;
import com.wdyc.njtclient.dto.RepairDTO;
import com.wdyc.njtclient.dto.ServiceDTO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class AddRepairItemAction extends AbstractAction {

    private static List<ItemDTO> items = new ArrayList<>();
    private static int rowNumber = 1;
    private static RepairDTO repair = new RepairDTO();

    public static RepairDTO getRepair() {
        return repair;
    }

    public static void setRepair(RepairDTO aRepair) {
        repair = aRepair;
    }

    public AddRepairItemAction() {
    }
    

    public static List<ItemDTO> getItems() {
        return items;
    }

    public static void setItems(List<ItemDTO> aItems) {
        items = aItems;
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        String type = request.getParameter("type");
        String pricePerUnit = request.getParameter("price");
        String amount = request.getParameter("amount");
        String price = String.valueOf(Double.valueOf(pricePerUnit)*Double.valueOf(amount));

        ItemDTO item = new ItemDTO();
        item.setAmount(amount);
        item.setPricePerUnit(pricePerUnit);
        item.setPrice(price);
        item.setRowNumber(rowNumber);
        rowNumber++;

        if (type.equalsIgnoreCase("service")) {
            ServiceDTO service = new ServiceDTO();
            String id = request.getParameter("services");
            String name = request.getParameter("service_name");
            service.setId(id);
            item.setService(service);
            item.setName(name);
        } else {
            CarPartDTO carPart = new CarPartDTO();
            String id = request.getParameter("parts");
            String name = request.getParameter("part_name");
            carPart.setId(id);
            item.setCarPart(carPart);
            item.setName(name);
        }
        
        items.add(item);
        repair.addItemToList(item);
        
        request.setAttribute("items", items);
        
        AddRepairAction addRepairAction = new AddRepairAction();
        return addRepairAction.execute(request);
    }

}
