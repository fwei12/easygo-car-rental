package com.cs5200.car_rental.models;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Clients extends User{
  private String driverLicense;
  private Integer adminId;
}
