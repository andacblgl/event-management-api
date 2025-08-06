package com.andac.eventmanager.controller;

// Bu sınıf, dışarıdan gelen HTTP isteklerini karşılar
// GET, POST, PUT, DELETE gibi işlemler buradan başlar

import com.andac.eventmanager.entity.Event;
import com.andac.eventmanager.service.EventService;
import com.andac.eventmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Bu sınıfın bir REST controller olduğunu belirtir
@RequestMapping("/events") // Tüm endpoint'ler /events ile başlar
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ReservationService reservationService;

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

    // POST /events/{id}/reserve → Etkinliğe rezervasyon yapar
    @PostMapping("/{id}/reserve")
    public ResponseEntity<String> reserveTicket(@PathVariable Long id) {
        try {
            reservationService.reserveTicket(id); // rezervasyon işlemi
            return ResponseEntity.ok("Rezervasyon başarıyla yapıldı.");
        } catch (RuntimeException e) {
            // Kapasite doluysa veya başka bir hata varsa
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
