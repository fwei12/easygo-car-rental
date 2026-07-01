package com.cs5200.car_rental.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vehicles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String VIN;
  private String brand;
  private Double price;
  private Integer numOfSeats;
  private Integer mileage;
  private String address;
  private Integer availability;
  private String info;
  private Integer adminId;
}
