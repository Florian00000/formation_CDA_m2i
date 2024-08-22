package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Order;
import org.example.service.OrderService;

import java.util.List;
import java.util.Optional;

@Path("/api/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService orderService;

    @GET
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GET
    @Path("{id}")
    public Order getOrderById(@PathParam("id") long id) {
        return orderService.getOrderById(id);
    }

    @POST
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    @PUT
    @Path("{id}")
    public Order updateOrder(@PathParam("id") long id, Order order) {
        return orderService.updateOrder(id, order);
    }

    @DELETE
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") long id) {
        orderService.deleteOrder(id);
        return Response.noContent().build();
    }
}
