package com.cs5200.car_rental.repository;


import com.cs5200.car_rental.models.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bills,Integer> {
  public Bills findFirstByBookingId(Integer id);
}
