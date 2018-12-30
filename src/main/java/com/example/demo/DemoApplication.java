package com.example.demo;

import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
  
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  
  @Autowired
  public DemoApplication(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }
  
  private ItemRepository itemRepository;
  
  @Override
  public void run(String... args) throws Exception {
    itemRepository.save(new Item("Pliers", "Good stuff", 27.0, 35));
    itemRepository.save(new Item("Hammer", "Low quality", 1.0, 2350));
    itemRepository.save(new Item("plastic banana", "Green", 1.0, 0));
  }
}