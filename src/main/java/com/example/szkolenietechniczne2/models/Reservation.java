package com.example.szkolenietechniczne2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationDate;
    private LocalDateTime stayStartDate;
    private LocalDateTime stayEndDate;
    private BigDecimal price;
    @OneToMany(mappedBy = "reservation")
    private List<Payment> payments;
    @ManyToOne
    private User user;
    @ManyToOne
    private PriceEntry priceEntry;
}
