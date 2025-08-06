package com.andac.eventmanager.service;

import com.andac.eventmanager.entity.Event;
import com.andac.eventmanager.entity.Reservation;
import com.andac.eventmanager.repository.EventRepository;
import com.andac.eventmanager.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ReservationService, rezervasyon işlemlerini yöneten servis katmanıdır.
 * Bir etkinliğe bilet ayırtmak gibi işlemleri burada kontrol ederiz.
 */

@Service
public class ReservationService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Bir etkinliğe rezervasyon yapar. Eğer kapasite doluysa hata fırlatır.
     * @param eventId Rezervasyon yapılacak etkinliğin ID’si
     * @return Rezervasyon objesi (başarıyla oluşturulursa)
     */
    public Reservation reserveTicket(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Etkinlik bulunamadı.");
        }

        Event event = eventOptional.get();

        if (event.getTicketsAvailable() <= 0) {
            throw new RuntimeException("Etkinlik dolu! Rezervasyon yapılamaz.");
        }

        // Kapasiteyi bir azalt
        event.setTicketsAvailable(event.getTicketsAvailable() - 1);
        eventRepository.save(event);

        // Yeni rezervasyon oluştur
        Reservation reservation = new Reservation();
        reservation.setEvent(event);
        return reservationRepository.save(reservation);
    }
}
