package com.example.szkolenietechniczne2.repositories;

import com.example.szkolenietechniczne2.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
