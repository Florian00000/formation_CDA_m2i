package org.example.rest_adapter.controller;

import org.example.entity.Event;
import org.example.rest_adapter.dto.EventPatch;
import org.example.rest_adapter.dto.EventPost;
import org.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody EventPost eventPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(eventPost.toEvent()));
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
