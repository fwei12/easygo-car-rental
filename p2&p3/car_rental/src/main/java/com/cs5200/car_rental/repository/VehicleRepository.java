package com.cs5200.car_rental.repository;


import com.cs5200.car_rental.models.Vehicles;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicles,Integer> {
  public List<Vehicles> findByAvailability(Integer availability);
}
