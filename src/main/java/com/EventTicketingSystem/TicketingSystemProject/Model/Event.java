package com.EventTicketingSystem.TicketingSystemProject.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String date;
    private int totalTickets;
    private int ticketsSold = 0;

    public Event() {}

    public Event(String name, String location, String date, int totalTickets) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.totalTickets = totalTickets;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public int getTotalTickets() { return totalTickets; }
    public void setTotalTickets(int totalTickets) { this.totalTickets = totalTickets; }
    public int getTicketsSold() { return ticketsSold; }
    public void setTicketsSold(int ticketsSold) { this.ticketsSold = ticketsSold; }

    public int getAvailableTickets() {
        return this.totalTickets - this.ticketsSold;
    }

    public void sellTickets(int count) {
        this.ticketsSold += count;
    }
}

