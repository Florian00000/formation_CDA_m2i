package com.example.tp_hexagonal_04.adapter.rest.dto;

import com.example.tp_hexagonal_04.domain.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventPost {
    private String name;
    private String type;
    private int availablePlaces;
    private int reservedPlaces;



    public Event toEvent(){
        return new Event(name, type, availablePlaces, reservedPlaces) ;
    }
}
