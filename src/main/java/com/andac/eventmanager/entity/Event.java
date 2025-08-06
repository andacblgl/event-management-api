package com.andac.eventmanager.entity;

// Bu sınıf, sistemdeki etkinlikleri (event) temsil eder.
// Her bir Event nesnesi, bir etkinliğe ait başlık, açıklama, konum, tarih, kapasite ve kalan bilet bilgilerini tutar.
// Ayrıca bu sınıf, etkinliğe katılan kullanıcıları da (User) içerir.

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // Bu anotasyon, bu sınıfın bir JPA varlığı (entity) olduğunu belirtir
@Table(name = "events") // Veritabanında karşılık gelen tablo adı "events" olacak
@Getter // Lombok sayesinde tüm getter'lar otomatik oluşur
@Setter // Lombok sayesinde tüm setter'lar otomatik oluşur
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan birincil anahtar
    private Long id;

    private String title;        // Etkinlik başlığı
    private String description;  // Etkinlik açıklaması
    private String location;     // Etkinlik yeri
    private LocalDate date;      // Etkinlik tarihi
    private int capacity;        // Toplam kapasite
    private int ticketsAvailable; // Kalan bilet sayısı

    // Etkinliğe katılan kullanıcıların listesi (OneToMany ilişkisi)
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    // İstersen bu listeye elle kullanıcı da ekleyebilirsin:
    public void addUser(User user) {
        users.add(user);
        user.setEvent(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.setEvent(null);
    }
}
