/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.dto;

import java.io.Serializable;

/**
 *
 * @author Dusan
 */
public class EngineDTO implements Serializable {
    
    private String id;
    private String name;
    private String fuel;
    private String kw;
    private String hp;
    private String volume;

    public EngineDTO() {
    }

    public EngineDTO(String name, String fuel, String kw, String hp, String volume) {        
        this.name = name;
        this.fuel = fuel;
        this.kw = kw;
        this.hp = hp;
        this.volume = volume;
    }

    public EngineDTO(String id, String name, String fuel, String kw, String hp, String volume) {
        this.id = id;
        this.name = name;
        this.fuel = fuel;
        this.kw = kw;
        this.hp = hp;
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
}
