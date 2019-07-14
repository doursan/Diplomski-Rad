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
public class AddServiceAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        return "add_service";
    }
    
}
