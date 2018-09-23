/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.rest.ws;

import java.text.MessageFormat;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
public class RestWSClient {
    
    private Client client;
    private WebTarget target;
    private static final String BASE_URI = "http://localhost:8080/NJTRestWS/webapi/";
    private static RestWSClient instance;

    private RestWSClient() {
        client = ClientBuilder.newClient();
    }   
    
    public static RestWSClient getInstance() {
        if(instance == null) 
            instance = new RestWSClient();
        return instance;
    }
    
    public Response getAll_JSON() {
        WebTarget resource = target;
        return resource.request(MediaType.APPLICATION_JSON).get(Response.class);         
    }
    
    public Response getManyByParameter_JSON(String param, String value) {
        WebTarget resource = target;
        resource = resource.path(MessageFormat.format("{0}/{1}", new Object[] {param, value}));
        return resource.request(MediaType.APPLICATION_JSON).get(Response.class);
        
    }
    
    public <T> T getByParameter_JSON(Class<T> responseType, String param, String value) {
        WebTarget resource = target;
        resource = resource.path(MessageFormat.format("{0}/{1}", new Object[] {param, value}));        
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public Response create_JSON(Object requestEntity) {
        WebTarget resource = target;
        return resource.request(MediaType.APPLICATION_JSON).post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }
    
    public Response update_JSON(Object requestEntity) {
        WebTarget resource = target;
        return resource.request(MediaType.APPLICATION_JSON).put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public WebTarget getTarget() {
        return target;
    }

    public void setTarget(String path) {
        target = client.target(BASE_URI).path(path);
    }
    
    
    
    
    
}
