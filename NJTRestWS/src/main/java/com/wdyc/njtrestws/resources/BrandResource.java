/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.resources;

import com.wdyc.njtrestws.dao.CarBrandDAO;
import com.wdyc.njtrestws.domen.CarBrandEntity;
import com.wdyc.njtrestws.dto.CarBrandDTO;
import com.wdyc.njtrestws.mapstruct.CarBrandMapper;
import com.wdyc.njtrestws.mapstruct.impl.CarBrandMapperImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dusan
 */
@Path("brands")
public class BrandResource {

    CarBrandDAO carBrandDao = new CarBrandDAO();
    
    CarBrandMapper carBrandMapper = new CarBrandMapperImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        try {
            List<CarBrandEntity> retrievedCarBrands = carBrandDao.retrieveAllCarBrands();
            List<CarBrandDTO> convertedBrands = new ArrayList<>();

            for (CarBrandEntity brand : retrievedCarBrands) {
                CarBrandDTO brandDto = carBrandMapper.carBrandEntityToDto(brand);
                convertedBrands.add(brandDto);
            }
            
            Response response = Response.ok(convertedBrands).build();
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex).build();
        }
    }
}
