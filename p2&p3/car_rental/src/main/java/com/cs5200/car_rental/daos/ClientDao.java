package com.cs5200.car_rental.daos;

import com.cs5200.car_rental.models.Clients;
import com.cs5200.car_rental.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

public class ClientDao {

  @Autowired
  private ClientRepository clientRepository;

  public List<Clients> findAll() {
    return clientRepository.findAll();
  }

  public Clients findById( Integer id){
    return clientRepository.findById(id).get();
  }

  public Integer findFirstByEmail(String email){
    return clientRepository.findFirstByEmail(email).getId();
  }

  public Integer findFirstByEmailAndPassword(String email, @PathVariable("password") String password){
    try {
      return clientRepository.findFirstByEmailAndPassword(email, password).getId();
    }catch (Exception e){
      return -1;
    }

  }


  public String create( Clients client){
    try {
      clientRepository.save(client);
      return "success";
    }catch (Exception e){
      return "error";
    }
  }


  public String update( Clients client){
    try {
      clientRepository.save(client);
      return "success";
    }catch (Exception e){
      return "error";
    }
  }

  public void deleteById(Integer id){
    clientRepository.deleteById(id);
  }

}
