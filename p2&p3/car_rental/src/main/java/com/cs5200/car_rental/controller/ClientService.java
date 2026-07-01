package com.cs5200.car_rental.controller;

import com.cs5200.car_rental.models.Clients;
import com.cs5200.car_rental.repository.ClientRepository;
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
@RequestMapping("/client")
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping("/findAll")
  public List<Clients> findAll() {
    return clientRepository.findAll();
  }

  @GetMapping("/findById/{id}")
  public Clients findById(@PathVariable("id") Integer id){
    return clientRepository.findById(id).get();

  }
  @GetMapping("/findByEmail/{email}")
  public Integer findFirstByEmail(@PathVariable("email") String email){
    return clientRepository.findFirstByEmail(email).getId();
  }

  @GetMapping("/findByEmailAndPassword/{email}/{password}")
  public Integer findFirstByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password){
    try {
      return clientRepository.findFirstByEmailAndPassword(email, password).getId();
    }catch (Exception e){
      return -1;
    }

  }


  @PostMapping("/save")
  public String save(@RequestBody Clients client){
    try {
      clientRepository.save(client);
      return "success";
    }catch (Exception e){
      return "error";
    }
  }
  @DeleteMapping("/deleteById/{id}")
  public void deleteById(@PathVariable("id") Integer id){
    clientRepository.deleteById(id);
  }
}
