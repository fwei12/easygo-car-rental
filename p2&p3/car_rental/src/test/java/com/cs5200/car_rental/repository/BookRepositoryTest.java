package com.cs5200.car_rental.repository;

import com.cs5200.car_rental.models.Bookings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
  @Autowired
  private BookingRepository bookingRepository;

  @Test
  void findAll() {
    System.out.println(bookingRepository.findAll());
  }

  @Test
  void save() {
    Bookings booking = new Bookings();
    booking.setVehicleId(100);
    try {
      bookingRepository.save(booking);
      System.out.println("success");
    }catch (Exception e){
      System.out.println("error");
    }

  }

  @Test
  void findById() {
    Bookings booking = bookingRepository.findById(1).get();
    System.out.println(booking);
  }


  @Test
  void findByClientId() {
    System.out.println(bookingRepository.findByClientId(7));
  }





  @Test
  public void deleteById() {
    bookingRepository.deleteById(1);
  }

  @Test
  void save2bill() {
    Bookings booking = new Bookings();
    Bookings booking2 = bookingRepository.save(booking);
    System.out.println(booking2);

  }


}
