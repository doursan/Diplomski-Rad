/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.resources;

import com.wdyc.njtrestws.dao.CarDAO;
import com.wdyc.njtrestws.domen.CarEntity;
import com.wdyc.njtrestws.dto.CarDTO;
import com.wdyc.njtrestws.mapstruct.CarMapper;
import com.wdyc.njtrestws.mapstruct.impl.CarMapperImpl;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Dusan
 */
@Path("cars")
public class CarResource {
 
    CarMapper carMapper = new CarMapperImpl();
    
    CarDAO carDao = new CarDAO();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveCar(@NotNull CarDTO car, @Context UriInfo uriInfo) {
            System.out.println("Pozivam SAVE CAR iz REST Servisa");
        try {            
            CarEntity convertedCar = carMapper.carDtoToEntity(car);
            CarEntity savedCar = carDao.saveCar(convertedCar);
            CarDTO responseCar = carMapper.carEntityToDto(savedCar);
            
            String id = String.valueOf(savedCar.getId());
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
            System.out.println(uri.toString());
            Response response = Response.created(uri).entity(responseCar).build();
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex.getMessage()).build();
        }
    }
}
