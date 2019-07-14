/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.resources;

import com.wdyc.njtrestws.dao.ServiceDAO;
import com.wdyc.njtrestws.domen.ServiceEntity;
import com.wdyc.njtrestws.dto.ServiceDTO;
import com.wdyc.njtrestws.mapstruct.ServiceMapper;
import com.wdyc.njtrestws.mapstruct.impl.ServiceMapperImpl;
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
@Path("services")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class ServiceResource {
    
    ServiceMapper serviceMapper = new ServiceMapperImpl();
    
    ServiceDAO serviceDao = new ServiceDAO();
    
    @GET
    public Response getAll() {

        try {
            List<ServiceEntity> retrievedServices = serviceDao.retrieveAllServices();
            List<ServiceDTO> convertedServices = new ArrayList<>();

            for (ServiceEntity service : retrievedServices) {
                ServiceDTO serviceDto = serviceMapper.serviceEntityToDto(service);
                convertedServices.add(serviceDto);
            }

            Response response = Response.ok(convertedServices).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }
    
    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response getServiceByName(@PathParam("name") @NotNull String name) {
        try {
            ServiceEntity retrievedService = serviceDao.retrieveServiceByName(name);
            ServiceDTO convertedService = serviceMapper.serviceEntityToDto(retrievedService);

            return Response.ok(convertedService).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex).build();
        }

    }    

    @POST
    public Response saveService(@NotNull ServiceDTO service, @Context UriInfo uriInfo) {
        try {
            ServiceEntity convertedService = serviceMapper.serviceDtoToEntity(service);
            ServiceEntity savedService = serviceDao.saveService(convertedService);
            ServiceDTO responseService = serviceMapper.serviceEntityToDto(savedService);

            String id = String.valueOf(savedService.getId());
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
            System.out.println(uri.toString());

            Response response = Response.created(uri).entity(responseService).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{serviceId}")    
    public Response updateService(@PathParam("serviceId") String id, @NotNull ServiceDTO service) {
        try {
            service.setId(id);
            ServiceEntity convertedService = serviceMapper.serviceDtoToEntity(service);
            ServiceEntity updatedService = serviceDao.updateService(convertedService);
            ServiceDTO responseService = serviceMapper.serviceEntityToDto(updatedService);
            
            Response response = Response.ok(responseService).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }
    
    @DELETE
    @Path("/{serviceId}")
    public Response removeService(@PathParam("serviceId") @NotNull int id) {
        try {
            ServiceEntity removedService = serviceDao.removeService(id);
            ServiceDTO convertedService = serviceMapper.serviceEntityToDto(removedService);

            Response response = Response.ok(convertedService).build();
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex.getMessage()).build();
        }
    }
    
}
