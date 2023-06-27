package com.example.szkolenietechniczne2.models;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Reservation reservation;
}
