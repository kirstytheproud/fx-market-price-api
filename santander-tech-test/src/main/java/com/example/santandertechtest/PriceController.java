package com.example.santandertechtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PriceController {

    @Autowired
    PriceRepository repository;

    @Autowired
    PriceService service = new PriceService();

    // filter by instrument name, sort by timestamp
    public Price latestPrice (String instrumentName){
        List<Price> instrument = service.parseCSVtoPrice().stream()
                .filter(x -> x.getInstrumentName().equals(instrumentName))
                .sorted(Comparator.comparing(Price::getTimestamp))
                .collect(Collectors.toList());
        Price latestPrice = instrument.get(instrument.size()-1);

        return latestPrice;
    }

    @GetMapping("/prices")
    public List<Price> getAllPrices() {
        List<Price> sortedPricesByTimestamp = service.parseCSVtoPrice().stream()
                .sorted(Comparator.comparing(Price::getTimestamp))
                .collect(Collectors.toList());
        return sortedPricesByTimestamp;
    }

    @GetMapping("/prices/latest/eurToUsd")
    public Price eurToUsd() {
        Price eurToUsd = latestPrice("EUR/USD");
        return service.latestPriceWithCommission(eurToUsd);
    }

    @GetMapping("/prices/latest/eurToJpy")
    public Price eurToJpy() {
        Price eurToJpy = latestPrice("EUR/JPY");
        return service.latestPriceWithCommission(eurToJpy);
    }

    @GetMapping("/prices/latest/gbpToUsd")
    public Price gbpToUsd() {
        Price gbpToUsd = latestPrice("GBP/USD");
        return service.latestPriceWithCommission(gbpToUsd);
    }

    // for user to store the latest price for a given instrument
    @GetMapping("/prices/saved")
    public ResponseEntity<List<Price>> savedPrices(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping("/prices/latest/eurToUsd")
    public String saveEurToUsd() {
        repository.save(eurToUsd());
        return "You have saved EUR/USD instrument price";
    }

    @PostMapping("/prices/latest/eurToJpy")
    public String saveEurToJpy() {
        repository.save(eurToJpy());
        return "You have saved EUR/JPY instrument price";
    }

    @PostMapping("/prices/latest/gbpToUsd")
    public String saveGbpToUsd() {
        repository.save(gbpToUsd());
        return "You have saved GBP/USD instrument price";
    }
}
