package org.example.demo_api_cookie_session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;

@Path("/hello-world")
public class HelloResource {


    @Context
    private UriInfo uriInfo;

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;


    @GET
    @Produces("text/plain")
    public String hello() {
        HttpSession session = request.getSession();
        System.out.println(uriInfo.getAbsolutePath());
        return "Hello, World!";
    }

    @GET
    @Path("/set-cookie")
    @Produces(MediaType.TEXT_PLAIN)
    public Response setCookie(){
        NewCookie cookie = new NewCookie("isLogged","true");
        return Response.ok("You have a new Cookie !!!").cookie(cookie).build();
    }

    @GET
    @Path("/get-cookie")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCookie(){
        Cookie[] cookies = request.getCookies();
        String message = "";
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie:cookies){
                System.out.println(cookie.getValue());
                message += cookie.getValue();
            }
            return Response.ok(message).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Pas de cookies !!!!").build();
    }

    @GET
    @Path("/set-session")
    @Produces(MediaType.TEXT_PLAIN)
    public Response setSession(){
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("attribut","value");
        return Response.ok("You have a Session attribut!!!").build();
    }


    @GET
    @Path("/get-session")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSession(){
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null){
            Object value = httpSession.getAttribute("attribut");
            return Response.ok("Valeur de Attribut : "+value).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Pas de Session !!!!").build();
    }




}