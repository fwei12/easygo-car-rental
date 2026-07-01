package com.cs5200.car_rental.daos;

import com.cs5200.car_rental.models.Vehicles;
import com.cs5200.car_rental.repository.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class VehicleDao {
  @Autowired
  private VehicleRepository vehicleRepository;

  public List<Vehicles> findAll() {
    return vehicleRepository.findAll();
  }

  public String create( Vehicles vehicles){
    try {
      vehicleRepository.save(vehicles);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  public String update( Vehicles vehicles){
    try {
      vehicleRepository.save(vehicles);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  public Vehicles findById( Integer id){
    return vehicleRepository.findById(id).get();

  }
  public List<Vehicles> findByAvailability( Integer availability){
    return vehicleRepository.findByAvailability(availability);

  }


  public void deleteById( Integer id){
    vehicleRepository.deleteById(id);
  }
}
