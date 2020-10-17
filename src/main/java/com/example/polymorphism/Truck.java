package com.example.polymorphism;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Truck implements Vehicle {

  @Id
  @GeneratedValue
  Long id;
  Long buyingPrice;
  String modelNo;
  Long engineCapacity;
  Long trunkVolumeCapacity;
}
