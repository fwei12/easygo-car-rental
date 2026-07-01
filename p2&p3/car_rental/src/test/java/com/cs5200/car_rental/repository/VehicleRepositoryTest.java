package com.cs5200.car_rental.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VehicleRepositoryTest {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Test
  void findAll(){
    System.out.println(vehicleRepository.findAll());
  }
  @Test
  void findById(){
    System.out.println(vehicleRepository.findById(2).get());
  }

  @Test
  void deleteById() {
    vehicleRepository.deleteById(2);
  }

  @Test
  void findByAvailability(){
    System.out.println(vehicleRepository.findByAvailability(1));
  }



}
