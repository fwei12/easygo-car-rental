package com.cs5200.car_rental.daos;

import com.cs5200.car_rental.models.Bookings;
import com.cs5200.car_rental.repository.BookingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingDao {

  @Autowired
  private BookingRepository bookingRepository;

  public List<Bookings> findAll() {
    return bookingRepository.findAll();
  }

  public String create(Bookings booking){
    try {
      bookingRepository.save(booking);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  public String update(Bookings booking){
    try {
      bookingRepository.save(booking);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  public Bookings findById(Integer id){
    return bookingRepository.findById(id).get();
  }


  public List<Bookings> findByClientId(Integer id){
    return bookingRepository.findByClientId(id);

  }

  public List<Bookings> findByVehicleId(Integer id){
    return bookingRepository.findByVehicleId(id);

  }


  public void deleteById(Integer id){
    bookingRepository.deleteById(id);

  }
}
