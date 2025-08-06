package com.andac.eventmanager.controller;

// Bu sınıf, dışarıdan gelen HTTP isteklerini karşılar
// GET, POST, PUT, DELETE gibi işlemler buradan başlar

import com.andac.eventmanager.entity.Event;
import com.andac.eventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Bu sınıfın REST API controller olduğunu belirtir
@RequestMapping("/events") // Tüm endpoint'ler /events ile başlar
public class EventController {

    @Autowired
    private EventService eventService;

    // GET /events → Tüm etkinlikleri getirir
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET /events/{id} → Belirli bir etkinliği getirir
    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // POST /events → Yeni etkinlik oluşturur
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createOrUpdateEvent(event);
    }

    // PUT /events/{id} → Var olan etkinliği günceller
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id); // Güncellenecek ID'yi sete ekledik
        return eventService.createOrUpdateEvent(event);
    }

    // DELETE /events/{id} → Etkinliği siler
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
