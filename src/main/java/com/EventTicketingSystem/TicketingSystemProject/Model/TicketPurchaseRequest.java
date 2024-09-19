package com.EventTicketingSystem.TicketingSystemProject.Model;

public class TicketPurchaseRequest {
    
        private Long eventId;
        private int numberOfTickets;
    
        public TicketPurchaseRequest() {}
    
        public TicketPurchaseRequest(Long eventId, int numberOfTickets) {
            this.eventId = eventId;
            this.numberOfTickets = numberOfTickets;
        }
    
        // Getters and Setters
        public Long getEventId() { return eventId; }
        public void setEventId(Long eventId) { this.eventId = eventId; }
        public int getNumberOfTickets() { return numberOfTickets; }
        public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }
    }
    
