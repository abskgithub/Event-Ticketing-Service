package com.EventTicketingSystem.TicketingSystemProject.Service;

import com.EventTicketingSystem.TicketingSystemProject.Model.Event;
import com.EventTicketingSystem.TicketingSystemProject.Repository.EventRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Transactional
    public synchronized boolean purchaseTickets(Long eventId, int numberOfTickets) {
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        if (eventOpt.isPresent()) {
            Event event = eventOpt.get();
            if (event.getAvailableTickets() >= numberOfTickets) {
                event.sellTickets(numberOfTickets);
                return true;
            }
        }
        return false;
    }

    public int getTotalTicketsSold(Long eventId) {
        return eventRepository.findById(eventId)
                .map(Event::getTicketsSold)
                .orElse(0);
    }

    public int getTotalRevenue(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isPresent()) {
            return event.get().getTicketsSold() * 100;  // Assume ticket price is $100
        }
        return 0;
    }
}

