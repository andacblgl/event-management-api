package com.andac.eventmanager.service;

// Bu sınıf, Event nesneleri için iş mantığını (business logic) içerir.
// Controller ile Repository arasındaki katmandır.
// Veritabanına kayıt, silme, güncelleme gibi işlemleri burada tanımlarız.

import com.andac.eventmanager.entity.Event;
import com.andac.eventmanager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Bu sınıfın bir servis (iş mantığı) sınıfı olduğunu Spring’e bildirir
public class EventService {

    @Autowired // Spring, EventRepository’yi otomatik olarak buraya enjekte eder
    private EventRepository eventRepository;

    // Tüm etkinlikleri getirir
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Belirli bir ID’ye sahip etkinliği getirir
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Yeni bir etkinlik oluşturur veya var olanı günceller
    public Event createOrUpdateEvent(Event event) {
        return eventRepository.save(event);
    }

    // Etkinliği ID ile siler
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
