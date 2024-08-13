package org.example.rest_adapter.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Event;

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
