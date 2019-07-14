/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.resources;

import com.wdyc.njtrestws.dao.RepairDAO;
import com.wdyc.njtrestws.domen.RepairEntity;
import com.wdyc.njtrestws.dto.RepairDTO;
import com.wdyc.njtrestws.mapstruct.RepairMapper;
import com.wdyc.njtrestws.mapstruct.impl.RepairMapperImpl;
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
@Path("repairs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class RepairResource {

    RepairMapper repairMapper = new RepairMapperImpl();

    RepairDAO repairDao = new RepairDAO();    
        
    @GET
    @Path("finished_user/{userId}")
    public Response getFinishedRepairsForUser(@PathParam("userId") @NotNull Integer userId) {
        try {
            List<RepairEntity> retrievedRepairs = repairDao.retrieveFinishedRepairsForUser(userId);
            List<RepairDTO> convertedRepairs = new ArrayList<>();

            for (RepairEntity repair : retrievedRepairs) {
                RepairDTO repairDto = repairMapper.repairEntityToDto(repair);
                convertedRepairs.add(repairDto);
            }

            Response response = Response.ok(convertedRepairs).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }  
    
    @GET
    @Path("repair_id/{repairId}")
    public Response getRepairsById(@PathParam("repairId") @NotNull Integer repairId) {
        try {
            RepairEntity retrievedRepair = repairDao.retrieveRepairsById(repairId);
            
                RepairDTO convertedRepair = repairMapper.repairEntityToDto(retrievedRepair);

            Response response = Response.ok(convertedRepair).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }        
         
    @GET
    @Path("active_user/{userId}")
    public Response getRepairsInProgressForUser(@PathParam("userId") @NotNull Integer userId) {
        try {
            List<RepairEntity> retrievedRepairs = repairDao.retrieveRepairsInProgressForUser(userId);
            List<RepairDTO> convertedRepairs = new ArrayList<>();

            for (RepairEntity repair : retrievedRepairs) {
                RepairDTO repairDto = repairMapper.repairEntityToDto(repair);
                convertedRepairs.add(repairDto);
            }

            Response response = Response.ok(convertedRepairs).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }       
    
    @GET
    @Path("active_shop/{shopId}")
    public Response getActiveRepairsForUser(@PathParam("shopId") @NotNull Integer shopId) {
        try {
            List<RepairEntity> retrievedRepairs = repairDao.retrieveActiveRepairsForShop(shopId);
            List<RepairDTO> convertedRepairs = new ArrayList<>();

            for (RepairEntity repair : retrievedRepairs) {
                RepairDTO repairDto = repairMapper.repairEntityToDto(repair);
                convertedRepairs.add(repairDto);
            }

            Response response = Response.ok(convertedRepairs).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response saveRepair(@NotNull RepairDTO repair, @Context UriInfo uriInfo) {
        System.out.println("Pozivam SAVE REPAIR iz REST Servisa");
        try {
            RepairEntity convertedRepair = repairMapper.repairDtoToEntity(repair);
            RepairEntity savedRepair = repairDao.saveRepair(convertedRepair);
            RepairDTO responseRepair = repairMapper.repairEntityToDto(savedRepair);

            String id = responseRepair.getId();
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
            System.out.println(uri.toString());
            Response response = Response.created(uri).entity(responseRepair).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }
    
    @PUT
    @Path("/{repairId}")
    public Response updateRepair(@PathParam("repairId") String id, @NotNull RepairDTO repair) {
        try {
            RepairEntity convertedRepair = repairMapper.repairDtoToEntity(repair);
            RepairEntity updatedRepair = repairDao.updateRepair(convertedRepair);
            RepairDTO responseRepair = repairMapper.repairEntityToDto(updatedRepair);
            
            Response response = Response.ok(responseRepair).build();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(e.getMessage()).build();
        }
    }
    
    @DELETE
    @Path("/{repairId}")
    public Response removeRepair(@PathParam("repairId") @NotNull int id) {
        try {
            RepairEntity removedRepair = repairDao.removeRepair(id);
            RepairDTO convertedRepair = repairMapper.repairEntityToDto(removedRepair);

            Response response = Response.ok(convertedRepair).build();
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex.getMessage()).build();
        }
    }
}
