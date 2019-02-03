/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ItemDTO;
import com.wdyc.njtclient.dto.RepairDTO;
import com.wdyc.njtclient.dto.UserDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class SelectRepairAction extends AbstractAction {

    private static List<RepairDTO> repairs = new ArrayList<>();

    public static List<RepairDTO> getRepairs() {
        return repairs;
    }

    public static void setRepairs(List<RepairDTO> aRepairs) {
        repairs = aRepairs;
    }

    public static void resetRepairs() {
        repairs = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("logged_user");
        String action = request.getParameter("action");

        RestWSClient.getInstance().setTarget(Constants.REPAIRS_PATH);

        Response response;
        if (user.getTip().equalsIgnoreCase("S")) {
            response = RestWSClient.getInstance().getManyByParameter_JSON(Constants.REPAIRS_ACTIVE_SHOP_PARAM, user.getId());
        } else {
            if (action.equalsIgnoreCase("view_repairs_in_progress")) {
                response = RestWSClient.getInstance().getManyByParameter_JSON(Constants.REPAIRS_ACTIVE_USER_PARAM, user.getId());
            } else {
                response = RestWSClient.getInstance().getManyByParameter_JSON(Constants.REPAIRS_FINISHED_USER_PARAM, user.getId());
            }
        }
        if (response.getStatus() == 200) {
            repairs = response.readEntity(new GenericType<List<RepairDTO>>() {
            });

            request.setAttribute("repairs", repairs);

            if (action.equalsIgnoreCase("change_repair")) {
                request.setAttribute("banner_page", "/WEB-INF/pages/update_repair_select_form.jsp");
                return "update_repair";
            }
            if (action.equalsIgnoreCase("view_repairs")) {
                request.setAttribute("banner_page", "/WEB-INF/pages/view_repairs_form.jsp");
                return "view_repairs";
            } 
            if (action.equalsIgnoreCase("view_repairs_in_progress")) {
                request.setAttribute("banner_page", "/WEB-INF/pages/view_repairs_in_progress_form.jsp");
                return "view_repairs_in_progress";
            } else {
                if (request.getParameterMap().containsKey("repairs")) {
                    String repairId = request.getParameter("repairs");
                    RepairDTO selectedRepair = new RepairDTO();
                    for (RepairDTO repair : repairs) {
                        if (repair.getId().equalsIgnoreCase(repairId)) {
                            selectedRepair = repair;
                            break;
                        }
                    }

                    Collections.sort(selectedRepair.getItemList(), new Comparator<ItemDTO>() {
                        @Override
                        public int compare(ItemDTO i1, ItemDTO i2) {
                            return i1.getRowNumber() - i2.getRowNumber();
                        }
                    });

                    request.setAttribute("repair", selectedRepair);
                    request.setAttribute("items", selectedRepair.getItemList());
                }

                if (action.equalsIgnoreCase("delete_repair")) {
                    request.setAttribute("banner_page", "/WEB-INF/pages/delete_repair_form.jsp");
                    return "delete_repair";
                }
                if (action.equalsIgnoreCase("finish_repair")) {
                    request.setAttribute("banner_page", "/WEB-INF/pages/finish_repair_form.jsp");
                    return "finish_repair";
                } else {
                    request.setAttribute("message", "Unrecognized servlet call!");
                    return "admin";
                }
            }
        } else {
            String poruka = response.readEntity(String.class);
            request.setAttribute("message", poruka);

            return "admin";
        }

    }

}
