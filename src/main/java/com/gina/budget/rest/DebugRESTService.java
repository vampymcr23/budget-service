package com.gina.budget.rest;

import com.gina.budget.rest.resources.HealthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Service
@Path("/admin")
public class DebugRESTService {

    @Value("${current.env}")
    private String variable;

    @GET
    @Path("/health")
    @Produces(MediaType.APPLICATION_JSON)
    public Response healthCheck(){
        HealthResponse response = new HealthResponse();
        response.setTime(LocalDateTime.now());
        response.setEnvironment(variable);
        return Response.ok(response).build();
    }

}
