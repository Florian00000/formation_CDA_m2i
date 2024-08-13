package com.example.tp_hexagonal_04.adapter.rest.config;

import com.example.tp_hexagonal_04.domain.service.EventService;
import com.example.tp_hexagonal_04.infrastructure.springdata.portimpl.EventPortImpl;
import com.example.tp_hexagonal_04.infrastructure.springdata.repository.EventRepository;
import com.example.tp_hexagonal_04.shared.port.EventPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final EventRepository eventRepository;

    @Autowired
    public AppConfig(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Bean
    public EventService eventService() {
        return new EventService(eventPort());
    }

    @Bean
    public EventPort eventPort(){
        return new EventPortImpl(eventRepository);
    }
}
