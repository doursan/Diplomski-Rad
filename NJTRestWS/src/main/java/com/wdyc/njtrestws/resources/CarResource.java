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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
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
@Path("cars")
public class CarResource {

    CarMapper carMapper = new CarMapperImpl();

    CarDAO carDao = new CarDAO();

    @GET
    @Path("user/{userid}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Response getCarsForUser(@PathParam("userid") @NotNull Integer userId) {
        try {
            List<CarEntity> retrievedCars = carDao.retrieveCarsForUser(userId);
            List<CarDTO> convertedCars = new ArrayList<>();

            for (CarEntity car : retrievedCars) {
                CarDTO carDto = carMapper.carEntityToDto(car);
                convertedCars.add(carDto);
            }

            Response response = Response.ok(convertedCars).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
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

    @PUT
    @Path("/{carId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Response updateCar(@PathParam("carId") String id, @NotNull CarDTO car) {
            System.out.println("Pozivam UPDATE CAR iz REST Servisa");
            car.setId(id);
        try {            
            CarEntity convertedCar = carMapper.carDtoToEntity(car);
            CarEntity updatedCar = carDao.updateCar(convertedCar);
            CarDTO responseCar = carMapper.carEntityToDto(updatedCar);
            Response response = Response.ok(responseCar).build();
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex.getMessage()).build();
        }
    }

}
