package org.example.service;

import org.example.entity.Event;
import org.example.port.EventPort;

import java.util.List;
import java.util.stream.Collectors;

public class EventService {

    private final EventPort eventPort;

    public EventService(EventPort eventPort) {
        this.eventPort = eventPort;
    }

    public Event createEvent(Event event) {
        return eventPort.save(event);
    }

    public Event getEvent(int id) {
        return eventPort.getEventById(id);
    }

    public List<Event> getAvailableEvents() {
        List<Event> events = eventPort.getEvents();
        return events.stream().filter(event -> event.getAvailablePlaces()>event.getReservedPlaces()).collect(Collectors.toList());
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
