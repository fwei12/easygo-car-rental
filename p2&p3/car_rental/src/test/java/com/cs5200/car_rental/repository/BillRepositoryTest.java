package com.cs5200.car_rental.repository;

import com.cs5200.car_rental.models.Bills;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BillRepositoryTest {

  @Autowired
  private BillRepository billRepository;

  @Test
  public void findAll() {
    System.out.println(billRepository.findAll());

  }

  @Test
  void findById() {
    Bills bill = billRepository.findById(1).get();
    System.out.println(bill);
  }

  @Test
  public void deleteById() {
    billRepository.deleteById(1);
  }

}