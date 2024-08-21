package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
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
}
