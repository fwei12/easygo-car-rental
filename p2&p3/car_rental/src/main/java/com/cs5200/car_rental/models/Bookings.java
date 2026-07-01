package com.cs5200.car_rental.models;

import java.sql.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Bookings {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String pickupLocation;
  private String returnLocation;
  private Date bookingDate;
  private Date departureDate;
  private Date returnDate;
  private Integer clientId;
  private Integer vehicleId;
}
