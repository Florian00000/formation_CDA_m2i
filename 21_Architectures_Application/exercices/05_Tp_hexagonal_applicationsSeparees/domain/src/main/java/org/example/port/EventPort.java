package org.example.port;

import org.example.entity.Event;

import java.util.List;

public interface EventPort {

    Event getEventById(int id);
    List<Event> getEvents();
    Event save(Event event);
    Event update(Event event);
//    Event registerTickets(Event event, int numberTickets);
//    Event cancelTickets(Event event, int numberTickets);
}
