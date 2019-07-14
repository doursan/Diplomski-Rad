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
        if (instance == null) {
            instance = new RestWSClient();
        }
        return instance;
    }

    public Response getAll_JSON() {
        return target.request(MediaType.APPLICATION_JSON).get(Response.class);
    }

    public Response getManyByParameter_JSON(String param, String value) {
        target = target.path(MessageFormat.format("{0}/{1}", new Object[]{param, value}));
        return target.request(MediaType.APPLICATION_JSON).get(Response.class);

    }

    public <T> T getByParameter_JSON(Class<T> responseType, String param, String value) throws Exception {
        try {
            target = target.path(MessageFormat.format("{0}/{1}", new Object[]{param, value}));
            return target.request(MediaType.APPLICATION_JSON).get(responseType);
        } catch (Exception e) {
            throw new Exception("Greska prilikom vracanja entiteta po parametru");
        }

    }

    public Response create_JSON(Object requestEntity) {
        return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response updateById_JSON(Object requestEntity, String id) {
        target = target.path(id);
        return target.request(MediaType.APPLICATION_JSON).put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response delete_JSON(String id) {
        return target.path(id).request(MediaType.APPLICATION_JSON).delete(Response.class);
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
