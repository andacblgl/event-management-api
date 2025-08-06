# Event Management API

A Spring Boot-based RESTful API for managing events and reservations.

## Features

- 🔄 **CRUD Operations** on Events (Create, Read, Update, Delete)
- 👥 **Add Users** to specific events
- 🎫 **Ticket Reservation System** with automatic capacity tracking
- 🔍 **List users** who registered to an event
- 📅 Hides past events (optional future feature)
- 🛡️ Input validation and basic error handling

## Technologies

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (in-memory for development)
- **Maven** (build & dependency management)
- **Lombok** (for boilerplate-free code)

## Getting Started

```bash
git clone https://github.com/andacblgl/event-management-api.git
cd event-management-api
mvn spring-boot:run
