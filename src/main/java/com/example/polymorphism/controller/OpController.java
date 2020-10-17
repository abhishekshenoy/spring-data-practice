package com.example.polymorphism.controller;

import com.example.polymorphism.repository.SalesTransactionRepository;
import com.example.polymorphism.model.Bus;
import com.example.polymorphism.model.SaleTransaction;
import com.example.polymorphism.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
public class OpController {

  @Autowired
  SalesTransactionRepository salesRepo;

  @GetMapping(path = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SaleTransaction> getTransaction(@PathVariable("id") Long id) {
    SaleTransaction sale=salesRepo.findById(id).get();
    return ResponseEntity.ok(sale);
  }

  @PostMapping(path = "/salesBus", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SaleTransaction> putBus() {
    ZoneId defaultZoneId = ZoneId.systemDefault();
    LocalDate localDate = LocalDate.of(2016, 8, 19);
    Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    SaleTransaction sale=SaleTransaction.builder().saleDate(date).salePrice(1000L).vehicle(
      Bus.builder().acAvailable(false).modelNo("New Model").buyingPrice(1000L).engineCapacity(1000L).seatCount(10).build()).build();
    sale = salesRepo.save(sale);
    return ResponseEntity.ok(sale);
  }

  @PostMapping(path = "/salesTruck", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SaleTransaction> putTruck() {
    ZoneId defaultZoneId = ZoneId.systemDefault();
    LocalDate localDate = LocalDate.of(2018, 8, 19);
    Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    SaleTransaction sale=SaleTransaction.builder().saleDate(date).salePrice(1000L).vehicle(
      Truck.builder().modelNo("New Model").buyingPrice(1000L).engineCapacity(1000L).trunkVolumeCapacity(10L).build()).build();
    sale = salesRepo.save(sale);
    return ResponseEntity.ok(sale);
  }

}
