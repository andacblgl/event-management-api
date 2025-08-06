package com.andac.eventmanager.service;

import com.andac.eventmanager.entity.Event;
import com.andac.eventmanager.entity.User;
import com.andac.eventmanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EventService, etkinliklerle ilgili tüm iş mantığını barındırır.
 * Etkinlik oluşturma, güncelleme, silme ve kullanıcıları listeleme gibi işlemler burada yapılır.
 */

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Tüm etkinlikleri getir
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Belirli ID’ye sahip etkinliği getir
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Etkinlik oluştur veya güncelle
    public Event createOrUpdateEvent(Event event) {
        return eventRepository.save(event);
    }

    // Etkinliği sil
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // Etkinliğe ait kullanıcı listesini getir
    public List<User> getUsersByEvent(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Etkinlik bulunamadı.");
        }
        return eventOptional.get().getUsers();
    }
}
