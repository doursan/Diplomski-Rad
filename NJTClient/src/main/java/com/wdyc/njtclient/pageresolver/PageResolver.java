/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.pageresolver;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dusan
 */
public class PageResolver {

    private static PageResolver instance;
    private Map<String, String> view;

    private PageResolver() {
        view = new HashMap<>();
        view.put("index", "/WEB-INF/pages/index.jsp");
        view.put("login", "/pages/login.jsp");
        view.put("register", "/pages/register.jsp");
        view.put("admin", "/WEB-INF/pages/admin.jsp");
        view.put("add_car", "/WEB-INF/pages/add_car.jsp");
        view.put("update_car", "/WEB-INF/pages/update_car.jsp");
        view.put("sell_car", "/WEB-INF/pages/sell_car.jsp");
    }

    public static PageResolver getInstance() {
        if (instance == null) {
            instance = new PageResolver();
        }
        return instance;
    }
    
    public String getPage(String key) {
        return view.get(key);
    }
}
