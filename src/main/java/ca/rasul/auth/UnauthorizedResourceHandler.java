package ca.rasul.auth;

import io.dropwizard.auth.UnauthorizedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class UnAuthorizedResourceHandler implements UnauthorizedHandler {

    @Context
    private HttpServletRequest request;

    @Override
    public Response buildResponse(String prefix, String realm) {
        Response.Status unauthorized = Response.Status.UNAUTHORIZED;
        return Response.status(unauthorized).type(MediaType.APPLICATION_JSON_TYPE).entity("Can't touch this...").build();
    }

    @Context
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}

