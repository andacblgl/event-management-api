package com.andac.eventmanager.entity;

import jakarta.persistence.*;

/**
 * User entity’si, etkinlik sistemine kayıt olan kişileri temsil eder.
 * Bu kullanıcılar daha sonra rezervasyon yapabilecek ve bir etkinliğe ait olacak.
 */

@Entity
@Table(name = "users") // Veritabanında tablo adı "users" olacak
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID
    private Long id;

    @Column(nullable = false)
    private String name; // Kullanıcının adı

    @Column(nullable = false)
    private String surname; // Kullanıcının soyadı

    @Column(nullable = false, unique = true)
    private String email; // Eşsiz e-posta adresi

    @Column
    private int age; // Kullanıcının yaşı

    @ManyToOne
    @JoinColumn(name = "event_id") // Foreign key sütunu
    private Event event; // Bu kullanıcı hangi etkinliğe ait

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
