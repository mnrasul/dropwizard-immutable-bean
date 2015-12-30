package ca.rasul.resources;

import ca.rasul.models.Message;
import ca.rasul.models.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class MessageResource {

    @POST
    public Response message(@HeaderParam("Accept-Language") @DefaultValue("en-US") String language, @BeanParam Message message){
        return Response.ok().language("en").entity(new Message("Message is "+message.getMessage())).build();
    }

    @GET
    public Response hello(@Auth User user){
        return Response.ok().entity("You got permission!").build();
    }
}
