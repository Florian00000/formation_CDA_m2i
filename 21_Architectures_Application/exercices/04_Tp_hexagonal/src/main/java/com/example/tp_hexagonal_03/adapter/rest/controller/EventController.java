package com.example.tp_hexagonal_03.adapter.rest.controller;

import com.example.tp_hexagonal_03.adapter.rest.dto.EventPatch;
import com.example.tp_hexagonal_03.domain.entity.Event;
import com.example.tp_hexagonal_03.domain.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAvailableEventsEvents() {
        return ResponseEntity.ok(eventService.getAvailableEvents());
    }

    @PatchMapping("/reservation/{id}")
    public ResponseEntity<Event> reserveEvent(@PathVariable Integer id, @RequestBody EventPatch eventPatch) {
        return ResponseEntity.ok(eventService.registerTickets(eventService.getEvent(id), eventPatch.getNumberPlaces()));
    }

    @PatchMapping("/cancellation/{id}")
    public ResponseEntity<Event> cancelTickets(@PathVariable Integer id, @RequestBody EventPatch eventPatch) {
        return ResponseEntity.ok(eventService.cancelTickets(eventService.getEvent(id), eventPatch.getNumberPlaces()));
    }
}
