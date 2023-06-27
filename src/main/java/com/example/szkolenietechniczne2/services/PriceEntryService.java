package com.example.szkolenietechniczne2.services;

import com.example.szkolenietechniczne2.models.PriceEntry;
import com.example.szkolenietechniczne2.repositories.PriceEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class PriceEntryService {
    private final PriceEntryRepository priceEntryRepository;

    public PriceEntryService(PriceEntryRepository priceEntryRepository) {
        this.priceEntryRepository = priceEntryRepository;
    }

    public Iterable<PriceEntry> getAllPriceEntries() {
        return priceEntryRepository.findAll();
    }

    public PriceEntry getPriceEntryById(Long priceEntryId) {
        return priceEntryRepository.findById(priceEntryId).orElse(null);
    }

    public PriceEntry createPriceEntry(PriceEntry priceEntry) {
        return priceEntryRepository.save(priceEntry);
    }

    public PriceEntry updatePriceEntry(PriceEntry priceEntry) {
        return priceEntryRepository.save(priceEntry);
    }

    public void deletePriceEntry(Long priceEntryId) {
        priceEntryRepository.deleteById(priceEntryId);
    }
}
