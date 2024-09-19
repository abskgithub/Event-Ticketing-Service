# Event Ticketing Service

This project is a simple **Event Ticketing Service** built using **Spring Boot**. It allows users to manage events, track ticket availability, and purchase tickets. 
Basic reporting on ticket sales and revenue is also provided.

## Features

### 1. **Event Management**
   - Create new events.
   - Retrieve details of specific events.
   - List all events.

### 2. **Ticket Inventory Management**
   - Track available tickets for each event.
   - Ensure that concurrent purchases do not lead to overselling of event tickets.

### 3. **Ticket Purchase Processing**
   - Allow users to purchase tickets for an event.
   - Handle concurrent ticket purchases safely.
   - Ensure that only one person can purchase a ticket when only one seat remains.

### 4. **Basic Reporting**
   - Get total tickets sold for an event.
   - Calculate revenue for an event.

---

## Project Structure

```
- src
  - main
    - java
      - com.ticketing
        - controller
          - EventController.java
        - model
          - Event.java
          - TicketPurchaseRequest.java
        - repository
          - EventRepository.java
        - service
          - EventService.java
        - TicketingApplication.java
    - resources
      - application.properties
- pom.xml
```

---

## Tech Stack

- **Spring Boot** - For building the REST API.
- **H2 Database** - In-memory database for managing event and ticket data.
- **Spring Data JPA** - For database interaction.
- **Postman** - For API testing.

---

## Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/abskgithub/Event-Ticketing-Service.git
   cd Event-Ticketing-Service
   ```

2. **Build the Project**

   You can build the project using Maven:
   ```bash
   mvn clean install
   ```

3. **Run the Application**

   Use Maven to run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application**

   The application will be accessible at: `http://localhost:8080`

5. **H2 Database Console**

   You can access the H2 database console at: `http://localhost:8080/h2-console`
   - Username: `sa`
   - Password: `password`

---

## API Documentation

### 1. **Create an Event**

   - **URL**: `/events`
   - **Method**: `POST`
   - **Request Body**:
     ```json
     {
       "name": "Concert",
       "location": "New York",
       "date": "2024-09-25",
       "totalTickets": 100
     }
     ```
   - **Response**: Event object with ID.

### 2. **Get All Events**

   - **URL**: `/events`
   - **Method**: `GET`
   - **Response**: List of all events.

### 3. **Get Event by ID**

   - **URL**: `/events/{id}`
   - **Method**: `GET`
   - **Response**: Event details for the specified event ID.

### 4. **Purchase Tickets**

   - **URL**: `/events/purchase`
   - **Method**: `POST`
   - **Request Body**:
     ```json
     {
       "eventId": 1,
       "numberOfTickets": 2
     }
     ```
   - **Response**: Success or failure message.

### 5. **Get Total Tickets Sold**

   - **URL**: `/events/{id}/tickets-sold`
   - **Method**: `GET`
   - **Response**: Total number of tickets sold for the specified event.

### 6. **Get Total Revenue**

   - **URL**: `/events/{id}/revenue`
   - **Method**: `GET`
   - **Response**: Total revenue generated from ticket sales for the specified event.

---

## Assumptions

- Each event has a single category of tickets (no VIP or other classes).
- Ticket price is fixed at $100 for simplicity.
- There is no authentication system; user IDs are assumed to be part of the request payload.
- Error handling is kept basic to focus on functionality.

---

## Postman Collection

A Postman collection is included in the repository (`Postman_Collection.json`) to facilitate easy testing of the API.

---

## Future Improvements

- Implementing user authentication for secure access.
- Adding different ticket categories (VIP, regular, etc.).
- Integrating payment gateway for real-world purchase processing.

---
