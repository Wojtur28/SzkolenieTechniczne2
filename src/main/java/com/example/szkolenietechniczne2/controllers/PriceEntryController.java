package com.example.szkolenietechniczne2.controllers;

import com.example.szkolenietechniczne2.models.PriceEntry;
import com.example.szkolenietechniczne2.services.PriceEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price-entries")
@CrossOrigin
public class PriceEntryController {

    private final PriceEntryService priceEntryService;

    public PriceEntryController(PriceEntryService priceEntryService) {
        this.priceEntryService = priceEntryService;
    }

    @GetMapping
    public ResponseEntity<Iterable<PriceEntry>> getAllPriceEntries() {
        Iterable<PriceEntry> priceEntries = priceEntryService.getAllPriceEntries();
        return ResponseEntity.ok(priceEntries);
    }

    @PostMapping
    public ResponseEntity<PriceEntry> createPriceEntry(@RequestBody PriceEntry priceEntry) {
        PriceEntry createdPriceEntry = priceEntryService.createPriceEntry(priceEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPriceEntry);
    }


    @PutMapping("/{priceEntryId}")
    public ResponseEntity<PriceEntry> updatePriceEntry(@PathVariable Long priceEntryId, @RequestBody PriceEntry priceEntry) {
        PriceEntry updatedPriceEntry = priceEntryService.updatePriceEntry(priceEntry);
        if (updatedPriceEntry != null) {
            updatedPriceEntry.setId(priceEntryId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedPriceEntry);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{priceEntryId}")
    public ResponseEntity<Void> deletePriceEntry(@PathVariable Long priceEntryId) {
        priceEntryService.deletePriceEntry(priceEntryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
