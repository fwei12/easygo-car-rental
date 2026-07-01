package com.cs5200.car_rental.daos;

import com.cs5200.car_rental.models.Bills;
import com.cs5200.car_rental.repository.BillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillDao {
  @Autowired
  private BillRepository billRepository;

  public List<Bills> findAll() {
    return billRepository.findAll();
  }

  public String create(Bills bill){
    try {
      billRepository.save(bill);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  public String update(Bills bill){
    try {
      billRepository.save(bill);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  public Bills findById(Integer id){
    return billRepository.findById(id).get();
  }

  public Bills findFirstByBookingId( Integer id){
    return billRepository.findFirstByBookingId(id);
  }


  public void deleteById(Integer id){
    billRepository.deleteById(id);
  }
}
