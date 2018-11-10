/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.resources;

import com.wdyc.njtrestws.dao.CarPartDAO;
import com.wdyc.njtrestws.domen.CarPartEntity;
import com.wdyc.njtrestws.dto.CarPartDTO;
import com.wdyc.njtrestws.mapstruct.CarPartMapper;
import com.wdyc.njtrestws.mapstruct.impl.CarPartMapperImpl;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Dusan
 */
@Path("parts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class CarPartResource {

    CarPartMapper carPartMapper = new CarPartMapperImpl();

    CarPartDAO carPartDao = new CarPartDAO();

    @GET
    public Response getAll() {

        try {
            List<CarPartEntity> retrievedCarParts = carPartDao.retrieveAllCarParts();
            List<CarPartDTO> convertedCarParts = new ArrayList<>();

            for (CarPartEntity part : retrievedCarParts) {
                CarPartDTO partDto = carPartMapper.carPartEntityToDto(part);
                convertedCarParts.add(partDto);
            }

            Response response = Response.ok(convertedCarParts).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response saveCarPart(@NotNull CarPartDTO carPart, @Context UriInfo uriInfo) {
        try {
            CarPartEntity convertedCarPart = carPartMapper.carPartDtoToEntity(carPart);
            CarPartEntity savedCarPart = carPartDao.saveCarPart(convertedCarPart);
            CarPartDTO responseCarPart = carPartMapper.carPartEntityToDto(savedCarPart);

            String id = String.valueOf(savedCarPart.getId());
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
            System.out.println(uri.toString());

            Response response = Response.created(uri).entity(responseCarPart).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{partId}")    
    public Response updateCarPart(@PathParam("partId") String id, @NotNull CarPartDTO carPart) {
        try {
            carPart.setId(id);
            CarPartEntity convertedCarPart = carPartMapper.carPartDtoToEntity(carPart);
            CarPartEntity updateCarPart = carPartDao.updateCarPart(convertedCarPart);
            CarPartDTO responseCarPart = carPartMapper.carPartEntityToDto(updateCarPart);
            
            Response response = Response.ok(responseCarPart).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }
    
    @DELETE
    @Path("/{partId}")
    public Response removeCarPart(@PathParam("partId") @NotNull int id) {
        try {
            CarPartEntity removedCarPart = carPartDao.removeCarPart(id);
            CarPartDTO convertedCarPart = carPartMapper.carPartEntityToDto(removedCarPart);

            Response response = Response.ok(convertedCarPart).build();
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex.getMessage()).build();
        }
    }

}
