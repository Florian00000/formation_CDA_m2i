package com.example.tp_hexagonal_03.infrastructure.springdata.portimpl;

import com.example.tp_hexagonal_03.domain.entity.Event;
import com.example.tp_hexagonal_03.infrastructure.springdata.entity.EventEntity;
import com.example.tp_hexagonal_03.infrastructure.springdata.repository.EventRepository;
import com.example.tp_hexagonal_03.shared.port.EventPort;

import java.util.List;

public class EventPortImpl implements EventPort {

    private final EventRepository repository;

    public EventPortImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event getEventById(int id) {
        EventEntity eventEntity = repository.findById(id).orElse(null);
        return new Event(eventEntity.getId(),
                eventEntity.getName(), eventEntity.getType(), eventEntity.getAvailablePlaces(), eventEntity.getReservedPlaces());
    }

    @Override
    public List<Event> getEvents() {
        List<EventEntity> list = (List<EventEntity>) repository.findAll() ;
        return list.stream().map(eventEntity ->
                new Event(eventEntity.getId(), eventEntity.getName(),
                        eventEntity.getType(), eventEntity.getAvailablePlaces(), eventEntity.getReservedPlaces()))
                .toList();
    }

    @Override
    public Event save(Event event) {
        EventEntity eventEntity = EventEntity.builder()
                .name(event.getName())
                .type(event.getType())
                .availablePlaces(event.getAvailablePlaces())
                .reservedPlaces(event.getReservedPlaces())
                .build();
        eventEntity = repository.save(eventEntity);
        return new Event(eventEntity.getId(),
                eventEntity.getName(), eventEntity.getType(),
                eventEntity.getAvailablePlaces(), eventEntity.getReservedPlaces());
    }

    @Override
    public Event update(Event event) {
        EventEntity eventEntity = repository.findById(event.getId()).orElse(null);
        eventEntity.setName(event.getName());
        eventEntity.setType(event.getType());
        eventEntity.setAvailablePlaces(event.getAvailablePlaces());
        eventEntity.setReservedPlaces(event.getReservedPlaces());
        repository.save(eventEntity);
        return new Event(eventEntity.getId(), event.getName(),
                event.getType(), event.getAvailablePlaces(), event.getReservedPlaces());
    }
}
