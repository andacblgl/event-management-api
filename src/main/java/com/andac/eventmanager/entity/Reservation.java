package com.andac.eventmanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Reservation entity'si, kullanıcıların bir etkinliğe yaptığı bilet rezervasyonlarını temsil eder.
 * Her rezervasyon bir etkinlik ile ilişkilidir ve rezervasyon tarihi tutulur.
 */

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Rezervasyonun benzersiz kimliği

    private String userName; // Bilet alan kişinin adı
    private String userEmail; // Bilet alan kişinin e-posta adresi

    private LocalDateTime reservationTime; // Rezervasyonun yapıldığı zaman

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event; // Bu rezervasyonun ait olduğu etkinlik
}
