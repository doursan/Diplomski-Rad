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
import com.wdyc.njtclient.validation.RepairValidator;
import java.util.ArrayList;
import java.util.Iterator;
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
        rowNumber = repair.getItemList().size() + 1;
    }

    public static void removeItem(int aRowNumber) {
        boolean removed = false;
        Iterator<ItemDTO> iter = repair.getItemList().iterator();
        while (iter.hasNext()) {
            ItemDTO item = iter.next();
            if (removed) {
                item.setRowNumber(item.getRowNumber() - 1);
                continue;
            }
            if (item.getRowNumber() == aRowNumber) {
                double newPrice = Double.parseDouble(repair.getPrice()) - Double.parseDouble(item.getPrice());
                repair.setPrice(String.valueOf(newPrice));
                iter.remove();
                removed = true;
            }
        }
        rowNumber--;
    }

    public AddRepairItemAction() {
    }

    public static List<ItemDTO> getItems() {
        return items;
    }

    public static void setItems(List<ItemDTO> aItems) {
        items = aItems;
    }

    public static void resetRepair() {
        repair = new RepairDTO();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String type = request.getParameter("type");
        String from = request.getParameter("from");
        String amount = request.getParameter("amount");
        String pricePerUnit;
        if (type.equalsIgnoreCase("service")) {
            pricePerUnit = request.getParameter("price");
        } else {
            pricePerUnit = request.getParameter("part_price");
        }

        ItemDTO item = new ItemDTO();
        item.setAmount(amount);
        item.setPricePerUnit(pricePerUnit);

        AddRepairAction addRepairAction = new AddRepairAction();

        if (!RepairValidator.getInstance().validateItem(item)) {
            if (type.equalsIgnoreCase("service")) {
                request.setAttribute("message_service", "Invalid service item");
                request.setAttribute("service_item", item);
                request.setAttribute("service_id", request.getParameter("services"));
                request.setAttribute("service_name", request.getParameter("service_name"));
            } else {
                request.setAttribute("message_part", "Invalid car part item");
                request.setAttribute("part_item", item);
                request.setAttribute("part_id", request.getParameter("parts"));
                request.setAttribute("part_name", request.getParameter("part_name"));
            }
            request.setAttribute("invalid_item", true);
            request.setAttribute("type", type);
            request.setAttribute("repair", repair);

            if (from.equalsIgnoreCase("update_repair")) {
                addRepairAction.execute(request);
                request.setAttribute("banner_page", "/WEB-INF/pages/update_repair_form.jsp");
                return "update_repair";
            } else {
                return addRepairAction.execute(request);
            }
        }

        if (pricePerUnit.isEmpty()) {
            pricePerUnit = "0";
            item.setPricePerUnit(pricePerUnit);
        }

        String price = String.valueOf(Double.valueOf(pricePerUnit) * Double.valueOf(amount));
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

        double newPrice = Double.parseDouble(repair.getPrice()) + Double.parseDouble(item.getPrice());
        repair.setPrice(String.valueOf(newPrice));
        items.add(item);
        repair.addItemToList(item);

        request.setAttribute("items", repair.getItemList());
        request.setAttribute("repair", AddRepairItemAction.getRepair());

        if (from.equalsIgnoreCase("update_repair")) {
            addRepairAction.execute(request);
            request.setAttribute("banner_page", "/WEB-INF/pages/update_repair_form.jsp");
            return "update_repair";
        } else {
            return addRepairAction.execute(request);
        }
    }

}
