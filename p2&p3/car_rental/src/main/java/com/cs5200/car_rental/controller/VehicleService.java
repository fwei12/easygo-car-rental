package com.cs5200.car_rental.controller;

import com.cs5200.car_rental.models.Vehicles;
import com.cs5200.car_rental.repository.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleService {

  @Autowired
  private VehicleRepository vehicleRepository;

  @GetMapping("/findAll")
  public List<Vehicles> findAll() {
    return vehicleRepository.findAll();
  }

  @PostMapping("/save")
  public String save(@RequestBody Vehicles vehicles){
    try {
      vehicleRepository.save(vehicles);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  @GetMapping("/findById/{id}")
  public Vehicles findById(@PathVariable("id") Integer id){
    return vehicleRepository.findById(id).get();

  }
  @GetMapping("/findByAvailability/{availability}")
  public List<Vehicles> findByAvailability(@PathVariable("availability") Integer availability){
    return vehicleRepository.findByAvailability(availability);

  }


  @DeleteMapping("/deleteById/{id}")
  public void deleteById(@PathVariable("id") Integer id){
    vehicleRepository.deleteById(id);
  }

}
