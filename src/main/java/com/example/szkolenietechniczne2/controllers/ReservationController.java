package com.example.szkolenietechniczne2.controllers;

import com.example.szkolenietechniczne2.models.Reservation;
import com.example.szkolenietechniczne2.models.User;
import com.example.szkolenietechniczne2.services.ReservationService;
import com.example.szkolenietechniczne2.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {
    private final ReservationService reservationService;
    private final UserServiceImpl userService;

    public ReservationController(ReservationService reservationService, UserServiceImpl userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        Iterable<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByEmail(username);
        reservation.setUser(user);

        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }


    @PutMapping("/{reservationId}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long reservationId, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        if (updatedReservation != null) {
            updatedReservation.setId(reservationId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedReservation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
