package com.andac.eventmanager.repository;

import com.andac.eventmanager.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Reservation nesneleriyle ilgili veritabanı işlemlerini yöneten repository.
 * Spring Data JPA sayesinde CRUD işlemlerini otomatik sağlar.
 */

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Şu an ekstra bir metoda gerek yok, JpaRepository yeterli
}
