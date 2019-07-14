/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dto;

/**
 *
 * @author Dusan
 */
public class ItemDTOPK {
    
    private String id;
    private String repairId;

    public ItemDTOPK() {
    }

    public ItemDTOPK(String id, String repairId) {
        this.id = id;
        this.repairId = repairId;
    }

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    
}
