package com.cs5200.car_rental.controller;

import com.cs5200.car_rental.models.Bookings;
import com.cs5200.car_rental.repository.BookingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @GetMapping("/findAll")
  public List<Bookings> findAll() {
    return bookingRepository.findAll();
  }

  @PostMapping("/save")
  public String save(@RequestBody Bookings booking){
    try {
      bookingRepository.save(booking);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  @GetMapping("/findById/{id}")
  public Bookings findById(@PathVariable("id") Integer id){
    return bookingRepository.findById(id).get();

  }

  @GetMapping("/findByClientId/{id}")
  public List<Bookings> findByClientId(@PathVariable("id") Integer id){
    return bookingRepository.findByClientId(id);

  }

  @GetMapping("/findByVehicleId/{id}")
  public List<Bookings> findByVehicleId(@PathVariable("id") Integer id){
    return bookingRepository.findByVehicleId(id);

  }


  @DeleteMapping("/deleteById/{id}")
  public void deleteById(@PathVariable("id") Integer id){
    bookingRepository.deleteById(id);

  }

}
