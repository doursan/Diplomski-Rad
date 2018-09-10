/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.action;

/**
 *
 * @author Dusan
 */
public class ActionFactory {

    public static AbstractAction createAction(String action) {

        AbstractAction command = null;
     
        if (action.equalsIgnoreCase("login")) {
            command = new LoginAction();
        }
        if (action.equalsIgnoreCase("register")) {
            command = new RegisterAction();
        }
        if (action.equalsIgnoreCase("add_car")) {
            command = new AddCarAction();
        }
        if (action.equalsIgnoreCase("save_car")) {
            command = new SaveCarAction();
        }

        return command;
    }
}
