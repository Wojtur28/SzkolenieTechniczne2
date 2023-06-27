package com.example.szkolenietechniczne2.repositories;

import com.example.szkolenietechniczne2.models.PriceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceEntryRepository extends JpaRepository<PriceEntry, Long> {
}
