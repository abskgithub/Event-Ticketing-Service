package com.EventTicketingSystem.TicketingSystemProject.Controller;

import com.EventTicketingSystem.TicketingSystemProject.Model.Event;
import com.EventTicketingSystem.TicketingSystemProject.Model.TicketPurchaseRequest;
import com.EventTicketingSystem.TicketingSystemProject.Service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTickets(@RequestBody TicketPurchaseRequest request) {
        boolean success = eventService.purchaseTickets(request.getEventId(), request.getNumberOfTickets());
        if (success) {
            return ResponseEntity.ok("Tickets purchased successfully.");
        } else {
            return ResponseEntity.status(400).body("Not enough tickets available.");
        }
    }

    @GetMapping("/{id}/tickets-sold")
    public int getTotalTicketsSold(@PathVariable Long id) {
        return eventService.getTotalTicketsSold(id);
    }

    @GetMapping("/{id}/revenue")
    public int getTotalRevenue(@PathVariable Long id) {
        return eventService.getTotalRevenue(id);
    }
}

