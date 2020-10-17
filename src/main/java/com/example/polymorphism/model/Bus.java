package com.example.polymorphism.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bus implements Vehicle {

  @Id
  @GeneratedValue
  Long id;
  Long buyingPrice;
  String modelNo;
  Long engineCapacity;
  int seatCount;
  boolean acAvailable;
}