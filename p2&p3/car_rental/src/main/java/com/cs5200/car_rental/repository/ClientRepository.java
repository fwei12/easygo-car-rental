package com.cs5200.car_rental.repository;


import com.cs5200.car_rental.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients,Integer> {

  public Clients findFirstByEmail(String email);
  public Clients findFirstByEmailAndPassword(String email, String password);


}
