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
        if (action.equalsIgnoreCase("update_car_page")) {
            command = new UpdateCarPageAction();
        }
        if (action.equalsIgnoreCase("update_car")) {
            command = new UpdateCarAction();
        }
        if (action.equalsIgnoreCase("sell_car_page")) {
            command = new SellCarPageAction();
        }  
        if (action.equalsIgnoreCase("sell_car")) {
            command = new SellCarAction();
        }
        if (action.equalsIgnoreCase("add_part")) {
            command = new AddCarPartAction();
        }     
        if (action.equalsIgnoreCase("save_part")) {
            command = new SaveCarPartAction();
        }
        if (action.equalsIgnoreCase("delete_part")) {
            command = new DeleteCarPartAction();
        }
        if (action.equalsIgnoreCase("remove_part")) {
            command = new RemoveCarPartAction();
        }
        if (action.equalsIgnoreCase("change_part")) {
            command = new ChangeCarPartAction();
        }
        if (action.equalsIgnoreCase("update_part")) {
            command = new UpdateCarPartAction();
        }
        if (action.equalsIgnoreCase("add_service")) {
            command = new AddServiceAction();
        }
        if (action.equalsIgnoreCase("save_service")) {
            command = new SaveServiceAction();
        }
        if (action.equalsIgnoreCase("change_service")) {
            command = new ChangeServiceAction();
        }
        if (action.equalsIgnoreCase("update_service")) {
            command = new UpdateServiceAction();
        }
        if (action.equalsIgnoreCase("delete_service")) {
            command = new DeleteServiceAction();
        }
        if (action.equalsIgnoreCase("remove_service")) {
            command = new RemoveServiceAction();
        }
        if (action.equalsIgnoreCase("create_repair")) {
            command = new AddRepairAction();
        }
        if (action.equalsIgnoreCase("add_repair_item")) {
            command = new AddRepairItemAction();
        }
        if (action.equalsIgnoreCase("save_repair")) {
            command = new SaveRepairAction();
        }
        return command;
    }
}
