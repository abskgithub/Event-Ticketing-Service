package com.EventTicketingSystem.TicketingSystemProject.Repository;


import com.EventTicketingSystem.TicketingSystemProject.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

