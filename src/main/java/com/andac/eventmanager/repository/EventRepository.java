package com.andac.eventmanager.repository;

// Bu interface, Event entity’si için veri tabanı işlemlerini sağlar.
// JpaRepository sayesinde CRUD işlemleri (Create, Read, Update, Delete) otomatik olarak hazır gelir.
// Örneğin: findAll(), save(), deleteById(), findById() gibi metotları yazmadan kullanabiliriz.


import com.andac.eventmanager.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Bu sınıfın bir Repository (veri erişim katmanı) olduğunu belirtir
public interface EventRepository extends JpaRepository<Event, Long> {
    // JpaRepository<entity_class, id_tipi>
    // Ekstra özel sorgular yazmak istersek buraya metotlar ekleyebiliriz
}