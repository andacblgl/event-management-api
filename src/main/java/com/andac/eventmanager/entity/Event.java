package com.andac.eventmanager.entity;

// Bu sınıf, sistemdeki etkinlikleri (event) temsil eder.
// Her bir Event nesnesi, bir etkinliğe ait başlık, açıklama, konum, tarih, kapasite ve kalan bilet bilgilerini tutar.
// Bu sınıf @Entity anotasyonu ile işaretlendiği için, veritabanında "events" isimli bir tabloya karşılık gelir.

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity // Bu anotasyon, bu sınıfın bir JPA varlığı (entity) olduğunu belirtir
@Table(name = "events") // Bu sınıfın veritabanındaki karşılık gelen tablo adının "events" olduğunu belirtir
@Getter // Lombok kütüphanesi sayesinde tüm getter (getId, getTitle vs) metotları otomatik oluşturulur
@Setter // Aynı şekilde tüm setter (setId, setTitle vs) metotları da otomatik oluşur

public class Event {

    @Id // Bu alan tablodaki birincil anahtar (primary key) olacak
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID değeri veritabanı tarafından otomatik artan şekilde oluşturulacak


    private Long id; // Her etkinliğe özel benzersiz bir kimlik (ID)

    private String title; // Etkinliğin başlığı (örneğin: Konser, Tiyatro Gecesi)

    private String description; // Etkinliğin açıklaması (örneğin: Bu etkinlik 90'lar Türkçe Pop konseridir.)

    private String location; // Etkinliğin yapılacağı yer bilgisi (örneğin: İstanbul Harbiye Açıkhava)

    private LocalDate date; // Etkinliğin tarihi (örneğin: 2025-08-15)

    private int capacity; // Etkinliğe maksimum katılabilecek kişi sayısı (örneğin: 500)

    private int ticketsAvailable; // Satılabilir mevcut bilet sayısı (örneğin: 120)


}