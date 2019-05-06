/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

import com.wdyc.njtclient.dto.CarPartDTO;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dusan
 */
public class AddCarPartAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        
        return "add_part";

    }

}
