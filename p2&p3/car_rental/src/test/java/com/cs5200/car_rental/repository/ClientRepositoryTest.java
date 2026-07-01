package com.cs5200.car_rental.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientRepositoryTest {

  @Autowired
  private ClientRepository clientRepository;

  @Test
  void findAll(){
    System.out.println(clientRepository.findAll());
  }
  @Test
  void findById(){
    System.out.println(clientRepository.findById(2).get());
  }

  @Test
  void deleteById() {
    clientRepository.deleteById(2);
  }

  @Test
  void  findFirstByEmail(){
    System.out.println(clientRepository.findFirstByEmail("timcook@apple.com"));
  }
  @Test
  void  findFirstByEmailAndPassword(){
    System.out.println(clientRepository.findFirstByEmailAndPassword("timcook@apple.com", "000000"));
  }

}
