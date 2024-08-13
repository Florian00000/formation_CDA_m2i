package com.example.tp_hexagonal_03.domain.service;

import com.example.tp_hexagonal_03.domain.entity.Event;
import com.example.tp_hexagonal_03.shared.port.EventPort;

import java.util.List;

public class EventService {

    private final EventPort eventPort;

    public EventService(EventPort eventPort) {
        this.eventPort = eventPort;
    }

    public Event getEvent(int id) {
        return eventPort.getEventById(id);
    }

    public List<Event> getAvailableEvents() {
        List<Event> events = eventPort.getEvents();
        return events.stream().filter(event -> event.getAvailablePlaces()>event.getReservedPlaces()).toList();
    }

    public Event registerTickets(Event event, int numberTickets){
        event.setReservedPlaces(event.getReservedPlaces() + numberTickets);
        return eventPort.update(event);
    }

    public Event cancelTickets(Event event, int numberTickets){
        event.setReservedPlaces(event.getReservedPlaces() - numberTickets);
        return eventPort.update(event);
    }
}
