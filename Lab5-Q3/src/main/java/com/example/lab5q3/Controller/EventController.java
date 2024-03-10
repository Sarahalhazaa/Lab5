package com.example.lab5q3.Controller;
import com.example.lab5q3.Api.ApiResponse;
import com.example.lab5q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/Event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();


    @GetMapping("/getEvent")
    public ArrayList<Event> getEvent() {
        return events;
    }

    @PostMapping("/addEvent")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added");
    }

    @PutMapping("/update/{index}")
    public  ApiResponse updatedEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new  ApiResponse(" Event updated ");
    }

    @DeleteMapping("/delete/{index}")
    public  ApiResponse deletedEvent(@PathVariable int index) {
        events.remove(index);
        return  new ApiResponse("Event Deleted");
    }
    @PutMapping("/updateCapacity/{index}/{capacity}")
    public ApiResponse updatedCapacity(@PathVariable int index, @PathVariable int capacity) {

          events.get(index).setCapacity(capacity);
            return new  ApiResponse(" Capacity Changed ");

    }


    @GetMapping("/SearchEvent/{id}")
    public ApiResponse SearchEvent(@PathVariable String id ){
        for (Event E : events) {
            if (E.getID().equalsIgnoreCase(id))
                return new ApiResponse( "Event: "+E);
        }
        return new ApiResponse( " Event is not found ");
    }




}
