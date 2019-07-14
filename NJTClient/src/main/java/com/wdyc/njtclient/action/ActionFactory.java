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

        if (action.equalsIgnoreCase("index")) {
            command = new IndexAction();
        }
        if (action.equalsIgnoreCase("index_admin")) {
            command = new IndexAdminAction();
        }
        if (action.equalsIgnoreCase("login")) {
            command = new LoginAction();
        }
        if (action.equalsIgnoreCase("logout")) {
            command = new LogoutAction();
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
        if (action.equalsIgnoreCase("change_service") || action.equalsIgnoreCase("view_services")) {
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
        if (action.equalsIgnoreCase("remove_item")) {
            command = new RemoveItemAction();
        }
        if (action.equalsIgnoreCase("save_repair")) {
            command = new SaveRepairAction();
        }
        if (action.equalsIgnoreCase("change_repair") || action.equalsIgnoreCase("finish_repair") || action.equalsIgnoreCase("delete_repair") || action.equalsIgnoreCase("view_repairs")|| action.equalsIgnoreCase("view_repairs_in_progress")) {
            command = new SelectRepairAction();
        }
        if (action.equalsIgnoreCase("update_repair_select")) {
            command = new UpdateRepairSelectAction();
        }
        if (action.equalsIgnoreCase("update_repair")) {
            command = new UpdateRepairAction();
        }
        if (action.equalsIgnoreCase("deactivate_repair")) {
            command = new FinishRepairAction();
        }
        if (action.equalsIgnoreCase("remove_repair")) {
            command = new RemoveRepairAction();
        }
        if (action.equalsIgnoreCase("ajax_reg_autocomplete")) {
            command = new AutocompleteRegistrationAction();
        } 
        if (action.equalsIgnoreCase("ajax_buy_autocomplete")) {
            command = new AutocompleteBuyerAction();
        } 
        if (action.equalsIgnoreCase("ajax_repair_items")) {
            command = new ItemsTableAction();
        } 
        if (action.equalsIgnoreCase("ajax_validate_user")) {
            command = new ValidateUserAction();
        } 
        if (action.equalsIgnoreCase("ajax_validate_part")) {
            command = new ValidatePartAction();
        } 
        if (action.equalsIgnoreCase("ajax_validate_service")) {
            command = new ValidateServiceAction();
        } 
        if (action.equalsIgnoreCase("ajax_validate_repair")) {
            command = new ValidateRepairAction();
        } 
        if (action.equalsIgnoreCase("ajax_validate_car")) {
            command = new ValidateCarAction();
        } 
        return command;
    }
}
