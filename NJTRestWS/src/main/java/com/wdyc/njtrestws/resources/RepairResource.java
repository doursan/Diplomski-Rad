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
@Path("repairs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class RepairResource {

    RepairMapper repairMapper = new RepairMapperImpl();

    RepairDAO repairDao = new RepairDAO();
    
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
}
