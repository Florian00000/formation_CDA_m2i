package org.example.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.configProperty.AppConfigService;

import java.awt.*;

@Path("/config")
public class ConfigResource {

    @Inject
    AppConfigService appConfigService;

    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(){
        return "Message : " + appConfigService.getMessage() +
                ", version : " + appConfigService.getVersion();
    }


    @GET
    @Path("/default")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDefault() {
        return "Message : " + appConfigService.getInfos();

    }


}
