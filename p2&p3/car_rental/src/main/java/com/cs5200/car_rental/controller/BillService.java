package com.cs5200.car_rental.controller;

import com.cs5200.car_rental.models.Bills;
import com.cs5200.car_rental.repository.BillRepository;
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
@RequestMapping("/bill")
public class BillService {

  @Autowired
  private BillRepository billRepository;

  @GetMapping("/findAll")
  public List<Bills> findAll() {
    return billRepository.findAll();
  }

  @PostMapping("/save")
  public String save(@RequestBody Bills bill){
    try {
      billRepository.save(bill);
      return "success";
    }catch (Exception e){
      System.out.println("error");
      return "error";
    }
  }

  @GetMapping("/findById/{id}")
  public Bills findById(@PathVariable("id") Integer id){
    return billRepository.findById(id).get();

  }
  @GetMapping("/findFirstByBookingId/{id}")
  public Bills findFirstByBookingId(@PathVariable("id") Integer id){
    return billRepository.findFirstByBookingId(id);

  }


  @DeleteMapping("/deleteById/{id}")
  public void deleteById(@PathVariable("id") Integer id){
    billRepository.deleteById(id);

  }

}
