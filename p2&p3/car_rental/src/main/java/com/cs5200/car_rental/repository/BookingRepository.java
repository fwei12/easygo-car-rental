package com.cs5200.car_rental.repository;


import com.cs5200.car_rental.models.Bookings;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Bookings,Integer> {
  public List<Bookings> findByClientId(Integer id);
  public List<Bookings> findByVehicleId(Integer id);
}
