/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ClientDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class AutocompleteBuyerAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String partialBuyer = request.getParameter("buyer");
        RestWSClient.getInstance().setTarget(Constants.CLIENTS_PATH);
        Response response = RestWSClient.getInstance().getManyByParameter_JSON(Constants.BUYER_SUGGEST_PARAM, partialBuyer);
        List<ClientDTO> buyers = new ArrayList<>();
        buyers = response.readEntity(new GenericType<List<ClientDTO>>() {
        });

        String suggestions = "";

        if (buyers.isEmpty()) {
            return "Not a valid buyer!";
        } else {
            for (ClientDTO buyer : buyers) {
                String line = "<a href=\"#buyer\"><div onclick='finish(\"" + buyer.getUsername() + "\")'>" + buyer.getUsername() + "</div></a>\n";
                suggestions += line;
            }
            System.out.println(suggestions);
            return suggestions;
        }
    }
}
