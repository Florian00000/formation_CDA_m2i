package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.scoped.GlobalrequestCounterService;
import org.example.scoped.RequestCounterService;

import java.awt.*;

@Path("/counter")
public class CounterResource {

    @Inject
    GlobalrequestCounterService globalrequestCounterService;

    @Inject
    RequestCounterService requestCounterService;



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String count(){

        globalrequestCounterService.increment();
        requestCounterService.increment();

        return "Global count "
                + globalrequestCounterService.getCount() +
                " Request Count : " +
                requestCounterService.getCount();
    }

}
