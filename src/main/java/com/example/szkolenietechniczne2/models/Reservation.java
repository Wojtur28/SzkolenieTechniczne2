package com.example.szkolenietechniczne2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;
    @Column(name = "stay_start_date")
    private LocalDateTime stayStartDate;
    @Column(name = "stay_end_date")
    private LocalDateTime stayEndDate;
    @OneToMany(mappedBy = "reservation")
    @JsonBackReference
    private List<Payment> payments;
    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
    @JoinColumn(name = "price_entry_id")
    private PriceEntry priceEntry;
}
