package com.andac.eventmanager.controller;

import com.andac.eventmanager.entity.User;
import com.andac.eventmanager.service.EventService;
import com.andac.eventmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Bu controller, kullanıcıların etkinliklere eklenmesini ve
 * etkinliğe ait kullanıcı listesinin alınmasını sağlar.
 */

@RestController
@RequestMapping("/events")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    // POST /events/{eventId}/users → Kullanıcıyı belirtilen etkinliğe ekle
    @PostMapping("/{eventId}/users")
    public String addUserToEvent(@PathVariable Long eventId, @RequestBody User user) {
        userService.addUserToEvent(eventId, user);
        return "Kullanıcı başarıyla etkinliğe eklendi.";
    }

    // GET /events/{id}/users → Belirli etkinliğe ait kullanıcıları getir
    @GetMapping("/{id}/users")
    public List<User> getUsersByEvent(@PathVariable Long id) {
        return eventService.getUsersByEvent(id);
    }
}
