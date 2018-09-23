package com.wdyc.njtrestws.resources;

import com.wdyc.njtrestws.dao.UserDAO;
import com.wdyc.njtrestws.domen.ClientEntity;
import com.wdyc.njtrestws.domen.ShopEntity;
import com.wdyc.njtrestws.domen.UserEntity;
import com.wdyc.njtrestws.dto.ClientDTO;
import com.wdyc.njtrestws.dto.ShopDTO;
import com.wdyc.njtrestws.dto.UserDTO;
import com.wdyc.njtrestws.mapstruct.ClientMapper;
import com.wdyc.njtrestws.mapstruct.ShopMapper;
import com.wdyc.njtrestws.mapstruct.UserMapper;
import com.wdyc.njtrestws.mapstruct.impl.ClientMapperImpl;
import com.wdyc.njtrestws.mapstruct.impl.ShopMapperImpl;
import com.wdyc.njtrestws.mapstruct.impl.UserMapperImpl;
import java.net.URI;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("users")
public class UserResource {

    UserDAO dao = new UserDAO();

    UserMapper userMapper = new UserMapperImpl();
    ClientMapper clientMapper = new ClientMapperImpl();
    ShopMapper shopMapper = new ShopMapperImpl();

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUsername(@PathParam("username") @NotNull String username) {
        try {
            UserEntity retrievedUser = dao.retrieveByUsername(username);
            UserDTO convertedUser = userMapper.userEntityToDto(retrievedUser);

            return Response.ok(convertedUser).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex).build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("shops")
    public Response registerShop(@NotNull ShopDTO user, @Context UriInfo uriInfo) {
        System.out.println("Pozivam Register SHOP iz REST Servisa");

        UserEntity registredUser;
        UserDTO responseUser = null;

        try {
            ShopEntity convertedUser = shopMapper.shopDtoToEntity(user);
            registredUser = dao.registerUser(convertedUser);
            responseUser = shopMapper.shopEntityToDto((ShopEntity) registredUser);
            
            String id = String.valueOf(responseUser.getId());
            URI uri = uriInfo.getBaseUriBuilder().path(UserResource.class).path(id).build();
            System.out.println(uri.toString());
            Response response = Response.created(uri).entity(responseUser).build();
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("clients")
    public Response registerShop(@NotNull ClientDTO user, @Context UriInfo uriInfo) {

        System.out.println("Pozivam Register CLIENT iz REST Servisa");

        UserEntity convertedUser, registredUser;
        UserDTO responseUser = null;
        try {
            convertedUser = clientMapper.clientDtoToEntity((ClientDTO) user);
            registredUser = dao.registerUser(convertedUser);
            responseUser = clientMapper.clientEntityToDto((ClientEntity) registredUser);
            
            String id = String.valueOf(responseUser.getId());
            URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
            return Response.created(uri).entity(responseUser).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().type(MediaType.TEXT_PLAIN).entity(ex).build();
        }
    }
}
