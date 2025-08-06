package com.andac.eventmanager.service;

import com.andac.eventmanager.entity.Event;
import com.andac.eventmanager.entity.User;
import com.andac.eventmanager.repository.EventRepository;
import com.andac.eventmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * UserService, kullanıcı işlemlerini yönetir:
 * - Kullanıcı oluşturma
 * - Etkinliğe kullanıcı ekleme
 * - Etkinliğe katılanları listeleme
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    // Yeni kullanıcıyı doğrudan kaydet
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Belirli bir etkinliğe kullanıcı ekle
    public User addUserToEvent(Long eventId, User user) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Etkinlik bulunamadı.");
        }

        Event event = eventOptional.get();
        user.setEvent(event);
        return userRepository.save(user);
    }

    // Belirli bir etkinliğe katılan tüm kullanıcıları getir
    public List<User> getUsersByEventId(Long eventId) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEvent() != null && user.getEvent().getId().equals(eventId))
                .toList();
    }
}
