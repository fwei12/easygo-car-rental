package com.cs5200.car_rental.models;


import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Bills {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer billNumber;
  private Date billDate;
  private Double amountToPaid;
  private Integer bookingId;
}
